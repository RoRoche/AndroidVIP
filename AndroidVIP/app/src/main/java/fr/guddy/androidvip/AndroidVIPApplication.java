package fr.guddy.androidvip;

import android.app.Application;

import fr.guddy.androidvip.di.DaggerAndroidVIPApplicationComponent;
import fr.guddy.androidvip.di.AndroidVIPApplicationComponent;

public class AndroidVIPApplication extends Application {

    //region Instance
    private static AndroidVIPApplication sInstance;

    public static AndroidVIPApplication getInstance() {
        return sInstance;
    }
    //endregion

    //region Dagger
    private AndroidVIPApplicationComponent mAndroidVIPApplicationComponent;

    public AndroidVIPApplicationComponent getAndroidVIPApplicationComponent() {
        return mAndroidVIPApplicationComponent;
    }

    public void setAndroidVIPApplicationComponent(final AndroidVIPApplicationComponent pAndroidVIPApplicationComponent) {
        mAndroidVIPApplicationComponent = pAndroidVIPApplicationComponent;
    }
    //endregion

    //region Lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        mAndroidVIPApplicationComponent = DaggerAndroidVIPApplicationComponent.builder().build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sInstance = null;
    }
    //endregion
}
