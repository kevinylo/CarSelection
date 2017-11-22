package kevin.lo.cardealers.modelselection.dagger;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import kevin.lo.cardealers.modelselection.ModelSelectionActivity;


@Module(subcomponents = ModelSelectionActivitySubcomponent.class)
public abstract class ModelSelectionActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(ModelSelectionActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity>
    bindModelSelectionActivityInjectorFactory(ModelSelectionActivitySubcomponent.Builder builder);
}
