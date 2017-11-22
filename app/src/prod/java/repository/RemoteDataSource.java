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


public class RemoteDataSource implements DataSource {

    private static final String JSON_FORMAT = "json";
    private static final String EDMUNDS_API_KEY = "ke2d4cv925rhhzgmkvmt755u";
    private static final String FULL_VIEW = "full";
    private static final String RADIUS_DEFAULT = "15";
    private static final String GOOGLE_GEOCODING_API_KEY = "AIzaSyBIljUykD7P_bgzzne3mvZEx5Fif0vEqMg";

    private EdmundsApi edmundsApi;
    private GoogleGeocodingApi googleGeocodingApi;

    @Inject
    public RemoteDataSource(EdmundsApi edmundsApi, GoogleGeocodingApi googleGeocodingApi) {
        this.edmundsApi = edmundsApi;
        this.googleGeocodingApi = googleGeocodingApi;
    }

    @Override
    public Observable<Makes> getMakes(int year) {
        return edmundsApi.getMakes(year, JSON_FORMAT, EDMUNDS_API_KEY);
    }

    @Override
    public Observable<Models> getModels(String make) {
        return edmundsApi.getModels(make, JSON_FORMAT, EDMUNDS_API_KEY);
    }

    @Override
    public Observable<Styles> getStyles(String makeName, String modelName, int year) {
        return edmundsApi.getStyles(makeName, modelName, year, JSON_FORMAT, EDMUNDS_API_KEY, FULL_VIEW);
    }

    @Override
    public Observable<Articles> getArticles(String make, String model, int year) {
        return edmundsApi.getArticles(make, model, year, JSON_FORMAT, EDMUNDS_API_KEY);
    }

    @Override
    public Observable<Dealers> getDealers(String zipCode, String make, String radius) {
        if (radius == null) {
            return edmundsApi.getDealers(zipCode, make, RADIUS_DEFAULT, JSON_FORMAT, EDMUNDS_API_KEY);
        } else {
            return edmundsApi.getDealers(zipCode, make, radius, JSON_FORMAT, EDMUNDS_API_KEY);
        }
    }

    @Override
    public Observable<Results> getAddress(Double latitude, Double longitude) {
        String latlng = latitude + "," + longitude;
        return googleGeocodingApi.getAddress(latlng, GOOGLE_GEOCODING_API_KEY);
    }
}
