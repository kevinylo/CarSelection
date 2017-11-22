package kevin.lo.cardealers.cardetails.dagger;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import kevin.lo.cardealers.cardetails.CarDetailsActivity;


@Module(subcomponents = CarDetailsActivitySubcomponent.class)
public abstract class CarDetailsActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(CarDetailsActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity>
    bindCarDetailsActivityInjectorFactory(CarDetailsActivitySubcomponent.Builder builder);
}