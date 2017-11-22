package kevin.lo.cardealers.cardetails.dagger;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kevin.lo.cardealers.cardetails.CarDetailsActivity;

@Subcomponent(
        modules = {
                CarDetailsActivityModule.class
        }
)
public interface CarDetailsActivitySubcomponent extends AndroidInjector<CarDetailsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CarDetailsActivity> {}
}
