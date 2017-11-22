package repository;


import io.reactivex.Observable;
import kevin.lo.cardealers.models.Results;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleGeocodingApi {

    @GET("maps/api/geocode/json")
    Observable<Results> getAddress(@Query("latlng") String latlng,
                                   @Query("key") String apiKey);
}
