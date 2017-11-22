package repository;


import io.reactivex.Observable;
import kevin.lo.cardealers.models.Articles;
import kevin.lo.cardealers.models.Dealers;
import kevin.lo.cardealers.models.Makes;
import kevin.lo.cardealers.models.Models;
import kevin.lo.cardealers.models.Styles;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EdmundsApi {

    @GET("vehicle/v2/makes")
    Observable<Makes> getMakes(@Query("year") int year,
                               @Query("fmt") String fmt,
                               @Query("api_key") String apiKey);

    @GET("vehicle/v2/{make}/models")
    Observable<Models> getModels(@Path("make") String make,
                                 @Query("fmt") String fmt,
                                 @Query("api_key") String apiKey);

    @GET("vehicle/v2/{make}/{model}/{year}/styles")
    Observable<Styles> getStyles(@Path("make") String make,
                                 @Path("model") String model,
                                 @Path("year") int year,
                                 @Query("fmt") String fmt,
                                 @Query("api_key") String apiKey,
                                 @Query("view") String view);

    @GET("editorial/v2/{make}/{model}/{year}/roadtests")
    Observable<Articles> getArticles(@Path("make") String make,
                                     @Path("model") String model,
                                     @Path("year") int year,
                                     @Query("fmt") String fmt,
                                     @Query("api_key") String apiKey);

    @GET("dealer/v2/dealers")
    Observable<Dealers> getDealers(@Query("zipcode") String zipCode,
                                   @Query("make") String make,
                                   @Query("radius") String radius,
                                   @Query("fmt") String fmt,
                                   @Query("api_key") String apiKey);
}
