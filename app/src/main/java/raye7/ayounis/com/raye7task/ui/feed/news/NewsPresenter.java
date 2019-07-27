package raye7.ayounis.com.raye7task.ui.feed.news;


import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.data.model.HomeData;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsPresenter<V extends NewsMvpView> extends BasePresenter<V>
        implements NewsMvpPresenter<V> {

    private long pageNumber;

    @Inject
    public NewsPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewPrepared() {
        pageNumber = getDataManager().getPageNumber();
        if ( pageNumber == 0 ) {
            getDataManager().setPageNumber(1);
        }

        getMvpView().showLoading();
        getDataManager().getHomeData("dcf37b3045e542df970986c1114eb3ea", "news", "day", (int) pageNumber, "USA Today", "en").enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                if (response.body().getArticles() != null) {
                    getDataManager().insertNews(response.body().getArticles());
                    getMvpView().updateArticles(getDataManager().getAllNews());
                    getMvpView().hideLoading();
                    pageNumber++;
                    getDataManager().setPageNumber(pageNumber);
                    getMvpView().changeLoading(true);
                }

            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {
                getMvpView().updateArticles(getDataManager().getAllNews());
                getMvpView().hideLoading();
            }
        });
    }


    @Override
    public void update(boolean articles, int id) {
        getDataManager().update(articles, id);
    }


}
