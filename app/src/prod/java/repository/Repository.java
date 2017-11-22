package repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Dealers;
import kevin.lo.cardealers.models.Makes;
import kevin.lo.cardealers.models.Models;
import kevin.lo.cardealers.models.Results;
import kevin.lo.cardealers.models.Styles;
import kevin.lo.cardealers.repository.DataSource;


public class Repository implements DataSource {

    private RemoteDataSource remoteDataSource;

    @Inject
    public Repository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<Makes> getMakes(int year) {
        return remoteDataSource.getMakes(year);
    }

    @Override
    public Observable<Models> getModels(String make) {
        return remoteDataSource.getModels(make);
    }

    @Override
    public Observable<Styles> getStyles(String makeName, String modelName, int year) {
        return remoteDataSource.getStyles(makeName, modelName, year);
    }

    @Override
    public Observable<Articles> getArticles(String make, String model, int year) {
        return remoteDataSource.getArticles(make, model, year);
    }

    @Override
    public Observable<Dealers> getDealers(String zipCode, String make, String radius) {
        return remoteDataSource.getDealers(zipCode, make, radius);
    }

    @Override
    public Observable<Results> getAddress(Double latitude, Double longitude) {
        return remoteDataSource.getAddress(latitude, longitude);
    }
}
