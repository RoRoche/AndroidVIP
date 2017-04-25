package fr.guddy.androidvip.di;

import javax.inject.Singleton;

import dagger.Component;
import fr.guddy.androidvip.ui.main.di.MainComponent;
import fr.guddy.androidvip.ui.main.di.MainModule;

@Singleton
@Component(modules = {})
public interface AndroidVIPApplicationComponent {
    MainComponent mainComponent(final MainModule pModule);
}
