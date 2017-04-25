package fr.guddy.androidvip.ui.main.di;

import dagger.Module;
import dagger.Provides;
import fr.guddy.androidvip.ui.main.MainInteractor;
import fr.guddy.androidvip.ui.main.MainPresenter;
import fr.guddy.androidvip.ui.main.MvpMain;

@Module
public class MainModule {
    @Provides
    @MainScope
    public MvpMain.Interactor provideInteractor() {
        return new MainInteractor();
    }

    @Provides
    @MainScope
    public MvpMain.Presenter providePresenter(final MvpMain.Interactor pInteractor) {
        return new MainPresenter(pInteractor);
    }
}
