package raye7.ayounis.com.raye7task;

import android.app.Application;

import raye7.ayounis.com.raye7task.di.component.ApplicationComponent;
import raye7.ayounis.com.raye7task.di.component.DaggerApplicationComponent;
import raye7.ayounis.com.raye7task.di.module.ApplicationModule;
import raye7.ayounis.com.raye7task.di.module.NetModule;
import raye7.ayounis.com.raye7task.utils.AppConstants;
import raye7.ayounis.com.raye7task.utils.AppLogger;
import retrofit2.Retrofit;

/**
 * Created by Ahmed Younis on 11/26/2018.
 */
public class Raye7App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(AppConstants.BASE_URLS)).build();
        mApplicationComponent.inject(this);


        AppLogger.init();

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent){
        mApplicationComponent = applicationComponent;
    }
}
