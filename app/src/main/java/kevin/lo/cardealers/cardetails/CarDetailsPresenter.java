package kevin.lo.cardealers.cardetails;


import android.support.annotation.VisibleForTesting;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import kevin.lo.cardealers.cardetails.view.DealerView;
import kevin.lo.cardealers.models.AddressComponent;
import kevin.lo.cardealers.models.Article;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Dealers;
import kevin.lo.cardealers.models.Results;
import kevin.lo.cardealers.models.Style;
import kevin.lo.cardealers.models.Styles;

import repository.Repository;


public class CarDetailsPresenter implements CarDetails.Presenter, DealerView.DirectionsCallback {

    private static final String ZIPCODE = "postal_code";
    public static final String DEFAULT_ZIPCODE = "90401";

    private CarDetailsActivity view;
    private Repository repository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CarDetailsPresenter(CarDetailsActivity view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getDetailedInformation(String makeName, String modelName, int year) {
        // get styling information and articles from two endpoints and combine
        compositeDisposable.add(
                Observable.zip(
                        repository.getStyles(makeName, modelName, year)
                                .subscribeOn(Schedulers.io()),
                        repository.getArticles(makeName, modelName, year)
                                .subscribeOn(Schedulers.io()),
                        new BiFunction<Styles, Articles, CarDetailsDataModel>() {
                            @Override
                            public CarDetailsDataModel apply(Styles styles, Articles articles) {
                                return new CarDetailsDataModel(styles, articles);
                            }
                        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CarDetailsDataModel>() {
                    @Override
                    public void accept(CarDetailsDataModel carDetailsDataModel) throws Exception {
                        processRetrievedModel(carDetailsDataModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // In case of error, show error on the View
                        view.hideDetailViews();
                        view.showErrorView();
                    }
                })
        );
    }

    @Override
    public void getDealerInformation(final String makeName, Double latitude, Double longitude) {
        // first get the zip code from current lat lng using Google Geocode api
        // Then feed the zip code to Edmunds api to get closest dealer
        compositeDisposable.add(
                repository.getAddress(latitude, longitude)
                        .subscribeOn(Schedulers.io())
                        .flatMap(new Function<Results, ObservableSource<Dealers>>() {
                            @Override
                            public ObservableSource<Dealers> apply(Results results) throws Exception {
                                return repository.getDealers(
                                        getZipCodeFromAddressResults(results), makeName, null
                                ).subscribeOn(Schedulers.io());
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Dealers>() {
                            @Override
                            public void accept(Dealers dealers) throws Exception {
                                processDealers(dealers);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                // In case of error - hide dealer information in the View
                                view.hideDealerInfo();
                            }
                        })
        );
    }

    @Override
    public void release() {
        compositeDisposable.dispose();
    }

    @Override
    public void onDirectionsButtonClicked(Double latitude, Double longitude) {
        view.showDirections(latitude, longitude);
    }

    @VisibleForTesting
    String getZipCodeFromAddressResults(Results results) {
        // do some sanity check if failed default to santa monica zip code
        if (results == null || results.getResults() == null || results.getResults().size() == 0
                || results.getResults().get(0) == null
                || results.getResults().get(0).getAddressComponents() == null) {
            return DEFAULT_ZIPCODE;
        } else {
            // traverse to retrieve zipcode
            List<AddressComponent> addressComponents = results.getResults().get(0).getAddressComponents();
            int numberOfComponents = addressComponents.size();

            for (int i = numberOfComponents - 1; i >= 0; i--) {
                AddressComponent addressComponent = addressComponents.get(i);
                if (addressComponent.getTypes().get(0).equals(ZIPCODE)) {
                    return addressComponent.getLongName();
                }
            }
            return DEFAULT_ZIPCODE;
        }
    }

    @VisibleForTesting
    void processRetrievedModel(CarDetailsDataModel carDetailsDataModel) {
        if (carDetailsDataModel == null || carDetailsDataModel.getStyles() == null ||
                carDetailsDataModel.getStyles().getStyles() == null ||
                carDetailsDataModel.getStyles().getStyles().size() == 0) {
            view.hideDetailViews();
            view.showErrorView();
        } else {
            List<Style> styleList = carDetailsDataModel.getStyles().getStyles();
            view.setStyleView(styleList);

            List<Article> articleList = carDetailsDataModel.getArticles().getArticles();
            if (articleList.size() > 0) {
                view.setArticleView(articleList);
            } else {
                view.hideArticleView();
            }
        }
    }

    private void processDealers(Dealers dealers) {
        // making sure dealer object has the address information
        if (dealers != null && dealers.getDealers() != null &&
                dealers.getDealers().size() > 0 &&
                dealers.getDealers().get(0).getAddress() != null) {
            view.setDealerView(dealers.getDealers().get(0));
        }
    }
}
