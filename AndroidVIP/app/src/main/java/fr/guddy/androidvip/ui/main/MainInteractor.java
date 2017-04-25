package fr.guddy.androidvip.ui.main;

public class MainInteractor implements MvpMain.Interactor {
    //region MvpMain.Interactor
    @Override
    public int compute(final int pA, final int pB) {
        return pA + pB;
    }
    //endregion
}
