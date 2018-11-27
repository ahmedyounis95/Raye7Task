package raye7.ayounis.com.raye7task.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.data.remote.ApiHelper;
import raye7.ayounis.com.raye7task.di.ApplicationContext;
import retrofit2.Call;

@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper){
        mContext = context;
        mApiHelper = apiHelper;
    }



    @Override
    public Call<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        return mApiHelper.getHomeData(apiKey,query,groupBy,page,source,language);
    }
}
