package fr.guddy.androidvip.rules;

import android.support.test.InstrumentationRegistry;

import fr.guddy.androidvip.AndroidVIPApplication;
import fr.guddy.androidvip.di.AndroidVIPApplicationComponent;
import it.cosenonjaviste.daggermock.DaggerMockRule;

public class AndroidVIPApplicationRule extends DaggerMockRule<AndroidVIPApplicationComponent> {
    public AndroidVIPApplicationRule() {
        super(AndroidVIPApplicationComponent.class);
        set((final AndroidVIPApplicationComponent pComponent) -> getAndroidVIPApplication().setAndroidVIPApplicationComponent(pComponent));
    }

    private AndroidVIPApplication getAndroidVIPApplication() {
        return (AndroidVIPApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
}
