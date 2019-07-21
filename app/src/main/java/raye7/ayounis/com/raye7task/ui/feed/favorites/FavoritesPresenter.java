package raye7.ayounis.com.raye7task.ui.feed.favorites;


import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;

public class FavoritesPresenter<V extends FavoritesMvpView> extends BasePresenter<V>
        implements FavoritesMvpPresenter<V> {

    @Inject
    public FavoritesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getMvpView().getDataFromDatabase(getDataManager().getAllFavorites());
        getMvpView().hideLoading();
    }



}
