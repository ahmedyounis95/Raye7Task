package raye7.ayounis.com.raye7task.ui.feed.favorites;


import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.Favorites;
import raye7.ayounis.com.raye7task.ui.base.MvpView;


public interface FavoritesMvpView extends MvpView {

    void getDataFromDatabase(List<Articles> articlesList);
}
