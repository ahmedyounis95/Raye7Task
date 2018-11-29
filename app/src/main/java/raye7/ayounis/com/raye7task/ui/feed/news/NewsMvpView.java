package raye7.ayounis.com.raye7task.ui.feed.news;


import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.ui.base.MvpView;

public interface NewsMvpView extends MvpView {

    void updateBlog(List<Articles> blogList);

    void changeLoading(boolean changeLoading);

    void getDataFromDatabase(List<Articles> articlesList);
}
