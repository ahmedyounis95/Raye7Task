package raye7.ayounis.com.raye7task.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import raye7.ayounis.com.raye7task.data.local.db.AppDbHelper;
import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.data.remote.ApiHelper;
import raye7.ayounis.com.raye7task.di.ApplicationContext;
import retrofit2.Call;

@Singleton
public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final AppDbHelper mAppDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper apiHelper,AppDbHelper appDbHelper){
        mContext = context;
        mApiHelper = apiHelper;
        mAppDbHelper = appDbHelper;
    }



    @Override
    public Call<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        return mApiHelper.getHomeData(apiKey,query,groupBy,page,source,language);
    }

    @Override
    public List<Articles> getAllArticles() {
        return mAppDbHelper.getAllArticles();
    }

    @Override
    public void insert(List<Articles> articlesList) {
        mAppDbHelper.insert(articlesList);
    }

    @Override
    public void remove(Articles articles) {
        mAppDbHelper.remove(articles);
    }
}
