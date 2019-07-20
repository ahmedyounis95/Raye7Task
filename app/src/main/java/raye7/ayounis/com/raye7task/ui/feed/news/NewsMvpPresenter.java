package raye7.ayounis.com.raye7task.ui.feed.news;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.Favorites;
import raye7.ayounis.com.raye7task.ui.base.MvpPresenter;

public interface NewsMvpPresenter<V extends NewsMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();

    void insertDatabase(Favorites articles);

    void update(boolean articles, int id);

    void removeFromDatabase(String articles);

    void getDatabase();
}


