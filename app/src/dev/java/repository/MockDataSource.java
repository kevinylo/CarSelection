package repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Dealers;
import kevin.lo.cardealers.models.Make;
import kevin.lo.cardealers.models.Makes;
import kevin.lo.cardealers.models.Model;
import kevin.lo.cardealers.models.Models;
import kevin.lo.cardealers.models.Results;
import kevin.lo.cardealers.models.Styles;
import kevin.lo.cardealers.repository.DataSource;


public class MockDataSource implements DataSource {

    @Override
    public Observable<Makes> getMakes(int year) {
        return getFakeMakes();
    }

    @Override
    public Observable<Models> getModels(String make) {
        return getFakeModels();
    }

    @Override
    public Observable<Styles> getStyles(String makeName, String modelName, int year) {
        return null;
    }

    @Override
    public Observable<Articles> getArticles(String make, String model, int year) {
        return null;
    }

    @Override
    public Observable<Dealers> getDealers(String zipCode, String make, String radius) {
        return null;
    }

    @Override
    public Observable<Results> getAddress(Double latitude, Double longitude) {
        return null;
    }

    private Observable<Makes> getFakeMakes() {
        final Makes makes = new Makes();

        Make make1 = new Make();
        make1.setId(1);
        make1.setName("mock car make 1");

        Make make2 = new Make();
        make2.setId(2);
        make2.setName("mock car make 2");

        Make make3 = new Make();
        make3.setId(3);
        make3.setName("mock car make 3");

        Make make4 = new Make();
        make4.setId(4);
        make4.setName("mock car make 4");

        final List<Make> makeList = new ArrayList<>();
        makeList.add(make1);
        makeList.add(make2);
        makeList.add(make3);
        makeList.add(make4);

        makes.setMakes(makeList);

        return new Observable<Makes>() {
            @Override
            protected void subscribeActual(Observer<? super Makes> observer) {
                observer.onNext(makes);
            }
        };
    }

    private Observable<Models> getFakeModels() {
        final Models models = new Models();

        Model model1 = new Model();
        model1.setId("1");
        model1.setName("mock car model 1");

        Model model2 = new Model();
        model2.setId("2");
        model2.setName("mock car model 2");

        Model model3 = new Model();
        model3.setId("3");
        model3.setName("mock car model 3");

        Model model4 = new Model();
        model4.setId("4");
        model4.setName("mock car model 4");

        final List<Model> modelList = new ArrayList<>();
        modelList.add(model1);
        modelList.add(model2);
        modelList.add(model3);
        modelList.add(model4);

        models.setModels(modelList);

        return new Observable<Models>() {
            @Override
            protected void subscribeActual(Observer<? super Models> observer) {
                observer.onNext(models);
            }
        };
    }
}
