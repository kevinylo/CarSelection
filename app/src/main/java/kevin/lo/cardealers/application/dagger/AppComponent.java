package kevin.lo.cardealers.application.dagger;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import kevin.lo.cardealers.application.CarSearchApp;
import kevin.lo.cardealers.cardetails.dagger.CarDetailsActivityBindingModule;
import kevin.lo.cardealers.makeselection.dagger.MakeSelectionActivityBindingModule;
import kevin.lo.cardealers.modelselection.dagger.ModelSelectionActivityBindingModule;
import repository.DataModule;


@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MakeSelectionActivityBindingModule.class,
        ModelSelectionActivityBindingModule.class,
        CarDetailsActivityBindingModule.class,
        DataModule.class
})
public interface AppComponent {
    void inject(CarSearchApp app);
    void inject(DataModule dataModule);
}
