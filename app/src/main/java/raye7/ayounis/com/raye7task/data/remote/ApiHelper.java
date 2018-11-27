package raye7.ayounis.com.raye7task.data.remote;

import raye7.ayounis.com.raye7task.data.model.HomeData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiHelper {

    @GET("v2/everything")
    Call<HomeData> getHomeData(@Query("apikey") String apiKey,
                               @Query("q") String query,
                               @Query("grouped") String groupBy,
                               @Query("page") int page,
                               @Query("source") String source,
                               @Query("language") String language);


}
