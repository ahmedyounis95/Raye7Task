package raye7.ayounis.com.raye7task.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import raye7.ayounis.com.raye7task.di.ApplicationContext;

/**
 * Created by Ahmed Younis on 11/26/2018.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }
    @Provides
    @ApplicationContext
    Context provideContext(){return mApplication;}

    @Provides
    Application provideApplication(){return mApplication;}


}
