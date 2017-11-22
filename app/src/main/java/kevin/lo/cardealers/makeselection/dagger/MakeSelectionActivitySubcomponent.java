package kevin.lo.cardealers.makeselection.dagger;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import kevin.lo.cardealers.makeselection.MakeSelectionActivity;


@Subcomponent(
        modules = {
                MakeSelectionActivityModule.class
        }
)
public interface MakeSelectionActivitySubcomponent extends AndroidInjector<MakeSelectionActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MakeSelectionActivity> {}
}
