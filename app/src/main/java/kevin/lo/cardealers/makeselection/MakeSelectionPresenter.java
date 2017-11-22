package kevin.lo.cardealers.makeselection;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kevin.lo.cardealers.models.Make;
import kevin.lo.cardealers.models.Makes;
import repository.Repository;

public class MakeSelectionPresenter implements MakeSelection.Presenter, MakeListViewHolder.OnMakeClickListener  {

    private MakeSelectionActivity view;
    private Repository repository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public MakeSelectionPresenter(MakeSelectionActivity view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getMakes() {
        compositeDisposable.add(
                repository.getMakes(2017)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Makes>() {
                    @Override
                    public void accept(Makes makes) throws Exception {
                        view.initializeListAdapter(makes.getMakes());
                    }
                })
        );
    }

    @Override
    public void release() {
        compositeDisposable.dispose();
    }

    @Override
    public void onMakeClicked(Make make) {
        view.startModelSelection(make.getNiceName());
    }
}
