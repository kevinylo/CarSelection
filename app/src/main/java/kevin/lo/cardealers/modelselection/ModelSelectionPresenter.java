package kevin.lo.cardealers.modelselection;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kevin.lo.cardealers.models.Model;
import kevin.lo.cardealers.models.Models;
import kevin.lo.cardealers.models.Year;
import repository.Repository;

public class ModelSelectionPresenter implements ModelSelection.Presenter, ModelListViewHolder.OnModelClickListener  {

    private ModelSelectionActivity view;
    private Repository repository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Model selectedModel;
    private String makeName;

    @Inject
    public ModelSelectionPresenter(ModelSelectionActivity view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getModels(String makeName) {
        this.makeName = makeName;
        compositeDisposable.add(
                repository.getModels(makeName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Models>() {
                    @Override
                    public void accept(Models models) throws Exception {
                        view.initializeListAdapter(models.getModels());
                    }
                })
        );
    }

    @Override
    public void release() {
        compositeDisposable.dispose();
    }

    @Override
    public void goToCarDetails(int year) {
        view.startCarDetailsActivity(makeName, selectedModel.getNiceName(), year);
    }

    @Override
    public void onModelClicked(Model model) {
        selectedModel = model;
        List<Year> yearRange = selectedModel.getYears();
        view.populateYearRange(yearRange.get(0).getYear(), yearRange.get(yearRange.size() - 1).getYear());
    }
}
