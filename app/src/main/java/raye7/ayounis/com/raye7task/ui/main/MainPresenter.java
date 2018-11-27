package raye7.ayounis.com.raye7task.ui.main;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {
    private int page = 1;
    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);

    }


    @Override
    public void onStartApp() {
        getMvpView().showLoading();
        getDataManager().getHomeData("dcf37b3045e542df970986c1114eb3ea","news","day",page,"USA Today","en").enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                getMvpView().updateArticleList(response.body().getArticles());
                page++;
                getMvpView().hideLoading();
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {

            }
        });


    }

}
