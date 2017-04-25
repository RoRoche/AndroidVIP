package fr.guddy.androidvip.ui.main;

import com.github.florent37.rxobserve.Rx;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends MvpBasePresenter<MvpMain.View> implements MvpMain.Presenter {
    //region Fields
    private final Interactor$$Observe mInteractor;
    //endregion

    //region Constructor
    public MainPresenter(final MvpMain.Interactor pInteractor) {
        mInteractor = Rx.observe(pInteractor);
    }
    //endregion

    //region MvpMain.Presenter
    @Override
    public void compute(final int pA, final int pB) {
        mInteractor.compute(pA, pB)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (@NonNull final Integer pResult) -> {
                            if (getView() != null && isViewAttached()) {
                                getView().onResult(pResult);
                            }
                        },
                        (@NonNull final Throwable pThrowable) -> {
                            if (getView() != null && isViewAttached()) {
                                getView().onFailure();
                            }
                        });
    }
    //endregion
}
