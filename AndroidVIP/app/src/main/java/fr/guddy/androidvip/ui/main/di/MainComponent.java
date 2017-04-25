package fr.guddy.androidvip.ui.main.di;

import dagger.Subcomponent;
import fr.guddy.androidvip.ui.main.MvpMain;

@MainScope
@Subcomponent(modules = {
        MainModule.class
})
public interface MainComponent {
    MvpMain.Presenter presenter();
}
