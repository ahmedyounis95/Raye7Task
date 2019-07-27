package raye7.ayounis.com.raye7task.data;


import raye7.ayounis.com.raye7task.data.local.db.DbHelper;
import raye7.ayounis.com.raye7task.data.local.prefs.PreferencesHelper;
import raye7.ayounis.com.raye7task.data.remote.ApiHelper;

public interface DataManager extends ApiHelper,DbHelper, PreferencesHelper {



}
