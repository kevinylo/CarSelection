package kevin.lo.cardealers.modelselection.dagger;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kevin.lo.cardealers.modelselection.ModelSelectionActivity;


@Subcomponent(
        modules = {
                ModelSelectionActivityModule.class
        }
)
public interface ModelSelectionActivitySubcomponent extends AndroidInjector<ModelSelectionActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ModelSelectionActivity> {}
}
