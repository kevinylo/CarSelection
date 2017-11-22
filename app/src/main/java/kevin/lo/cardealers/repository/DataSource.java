package kevin.lo.cardealers.repository;


import io.reactivex.Observable;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Dealers;
import kevin.lo.cardealers.models.Makes;
import kevin.lo.cardealers.models.Models;
import kevin.lo.cardealers.models.Results;
import kevin.lo.cardealers.models.Styles;


public interface DataSource {

    Observable<Makes> getMakes(int year);

    Observable<Models> getModels(String make);

    Observable<Styles> getStyles(String makeName, String modelName, int year);

    Observable<Articles> getArticles(String make, String model, int year);

    Observable<Dealers> getDealers(String zipCode, String make, String radius);

    Observable<Results> getAddress(Double latitude, Double longitude);
}
