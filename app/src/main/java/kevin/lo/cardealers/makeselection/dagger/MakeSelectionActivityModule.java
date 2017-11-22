package kevin.lo.cardealers.makeselection.dagger;


import dagger.Module;
import dagger.Provides;
import kevin.lo.cardealers.makeselection.MakeSelectionActivity;
import kevin.lo.cardealers.makeselection.MakeSelectionPresenter;
import repository.Repository;


@Module
public class MakeSelectionActivityModule {

    @Provides
    public MakeSelectionPresenter provideMainActivityPresenter(MakeSelectionActivity view, Repository repository) {
        return new MakeSelectionPresenter(view, repository);
    }
}
