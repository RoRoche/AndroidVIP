package fr.guddy.androidvip.ui.main;

import com.github.florent37.rxobserve.annotations.Single;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface MvpMain {
    interface View extends MvpView {
        void onResult(final int pResult);

        void onFailure();
    }

    interface Presenter extends MvpPresenter<View> {
        void compute(final int pA, final int pB);
    }

    interface Interactor {
        @Single
        int compute(final int pA, final int pB);
    }
}
