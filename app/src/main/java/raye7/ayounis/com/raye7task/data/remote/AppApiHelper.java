package raye7.ayounis.com.raye7task.data.remote;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import raye7.ayounis.com.raye7task.Raye7App;
import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.di.ApplicationContext;
import retrofit2.Call;
import retrofit2.Retrofit;

@Singleton
public class AppApiHelper implements ApiHelper {

    private Context mContext;

    @Inject
    public AppApiHelper(@ApplicationContext Context context){
        this.mContext = context;
    }



    @Override
    public Call<HomeData> getHomeData(String apiKey, String query, String groupBy, int page, String source, String language) {
        Retrofit retrofit = ((Raye7App)mContext).getComponent().getRetrofit();
        return retrofit.create(ApiHelper.class).getHomeData(apiKey,query,groupBy,page,source,language);
    }
}
