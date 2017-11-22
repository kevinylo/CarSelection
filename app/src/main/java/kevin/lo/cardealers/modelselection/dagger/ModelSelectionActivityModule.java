package kevin.lo.cardealers.modelselection.dagger;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import kevin.lo.cardealers.modelselection.ModelSelectionActivity;
import kevin.lo.cardealers.modelselection.ModelSelectionPresenter;
import repository.Repository;


@Module
public class ModelSelectionActivityModule {

    @Provides
    public ModelSelectionPresenter provideModelSelectionActivityPresenter(ModelSelectionActivity view, Repository repository) {
        return new ModelSelectionPresenter(view, repository);
    }
}
