package repository;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class DataModule {

    private static String baseUrl = "http://api.edmunds.com/api/";
    private static String googleBaseUrl = "https://maps.googleapis.com/";

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    @Named("edmunds")
    Retrofit provideRetrofitForEdmunds(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    @Named("google")
    Retrofit provideRetrofitForGoogle(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(googleBaseUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    EdmundsApi provideEdmundsApi(@Named("edmunds") Retrofit retrofit) {
        return retrofit.create(EdmundsApi.class);
    }

    @Provides
    @Singleton
    GoogleGeocodingApi provideGoogleGeocodingApi(@Named("google") Retrofit retrofit) {
        return retrofit.create(GoogleGeocodingApi.class);
    }

    @Provides
    @Singleton
    Repository provideRepository(RemoteDataSource remoteDataSource) {
        return new Repository(remoteDataSource);
    }
}
