package raye7.ayounis.com.raye7task.ui.feed.news;

import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.ui.base.MvpPresenter;

public interface NewsMvpPresenter<V extends NewsMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();

    void insertDatabase(List<Articles> articles);

    void removeFromDatabase(Articles articles);

    void getDatabase();
}


