package raye7.ayounis.com.raye7task.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import raye7.ayounis.com.raye7task.Raye7App;
import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.di.ApplicationContext;
import raye7.ayounis.com.raye7task.di.module.ApplicationModule;
import raye7.ayounis.com.raye7task.di.module.NetModule;
import retrofit2.Retrofit;

/**
 * Created by Ahmed Younis on 11/26/2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    void inject(Raye7App raye7App);

    @ApplicationContext
    Context context();

    Retrofit getRetrofit();

    Application application();

    DataManager getDataManager();


}
