package raye7.ayounis.com.raye7task.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.di.ApplicationContext;
import raye7.ayounis.com.raye7task.di.PreferenceInfo;

/**
 * Created by Ahmed Younis on 7/26/2019.
 */
public class AppPreferencesHelper implements PreferencesHelper {
    private static final String PREF_KEY_CURRENT_PAGE_NUMBER = "PREF_KEY_CURRENT_PAGE_NUMBER";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context, @PreferenceInfo String prefName) {

        mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }


    @Override
    public long getPageNumber() {
        long id = mPrefs.getLong(PREF_KEY_CURRENT_PAGE_NUMBER,0);;
        return id;
    }

    @Override
    public void setPageNumber(long pageNumber) {

        if(pageNumber != 0){
            mPrefs.edit().putLong(PREF_KEY_CURRENT_PAGE_NUMBER, pageNumber).apply();
        }
    }
}
