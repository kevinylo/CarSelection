package kevin.lo.cardealers.makeselection.dagger;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import kevin.lo.cardealers.makeselection.MakeSelectionActivity;


@Module(subcomponents = MakeSelectionActivitySubcomponent.class)
public abstract class MakeSelectionActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(MakeSelectionActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity>
    bindMakeSelectionActivityInjectorFactory(MakeSelectionActivitySubcomponent.Builder builder);
}
