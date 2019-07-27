package raye7.ayounis.com.raye7task.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import raye7.ayounis.com.raye7task.data.AppDataManager;
import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.data.local.db.AppDataBase;
import raye7.ayounis.com.raye7task.data.local.db.Dao.ArticleListDao;
import raye7.ayounis.com.raye7task.data.local.prefs.AppPreferencesHelper;
import raye7.ayounis.com.raye7task.data.local.prefs.PreferencesHelper;
import raye7.ayounis.com.raye7task.data.remote.ApiHelper;
import raye7.ayounis.com.raye7task.data.remote.AppApiHelper;
import raye7.ayounis.com.raye7task.di.ApplicationContext;
import raye7.ayounis.com.raye7task.di.PreferenceInfo;
import raye7.ayounis.com.raye7task.utils.AppConstants;

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
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDataBase provideAppDbHelper(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, AppConstants.DB_NAME).allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
    @Provides
    @Singleton
    ArticleListDao provideDbHelper(AppDataBase appDataBase) {
        return appDataBase.dbHelper();
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }
}
