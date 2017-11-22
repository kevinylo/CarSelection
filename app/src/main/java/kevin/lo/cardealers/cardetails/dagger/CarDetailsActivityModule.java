package kevin.lo.cardealers.cardetails.dagger;

import dagger.Module;
import dagger.Provides;
import kevin.lo.cardealers.cardetails.CarDetailsActivity;
import kevin.lo.cardealers.cardetails.CarDetailsPresenter;
import repository.Repository;


@Module
public class CarDetailsActivityModule {

    @Provides
    public CarDetailsPresenter provideCarDetailsActivityPresenter(CarDetailsActivity view, Repository repository) {
        return new CarDetailsPresenter(view, repository);
    }
}
