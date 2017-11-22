package repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.http.POST;


@Module
public class DataModule {

    @Provides
    @Singleton
    MockDataSource provideMockDataSource() {
        return new MockDataSource();
    }

    @Provides
    @Singleton
    Repository provideRepository(MockDataSource mockDataSource) {
        return new Repository(mockDataSource);
    }
}
