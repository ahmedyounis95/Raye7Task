package raye7.ayounis.com.raye7task.ui.feed.news;


import java.util.List;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class NewsPresenter<V extends NewsMvpView> extends BasePresenter<V>
        implements NewsMvpPresenter<V> {

    private int page = 1;

    @Inject
    public NewsPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getDataManager().getHomeData("dcf37b3045e542df970986c1114eb3ea", "news", "day", page, "USA Today", "en").enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                getMvpView().updateBlog(response.body().getArticles());
                getMvpView().hideLoading();
                page++;
                getMvpView().changeLoading(true);
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {

            }
        });
    }

    @Override
    public void insertDatabase(List<Articles> articles) {
        getDataManager().insert(articles);
    }

    @Override
    public void removeFromDatabase(Articles articles) {
        getDataManager().remove(articles);
    }

    @Override
    public void getDatabase() {
        if (getDataManager().getAllArticles().size() != 0) {
            getMvpView().getDataFromDatabase(getDataManager().getAllArticles());
        }
    }

}
