package raye7.ayounis.com.raye7task.ui.main;


import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Article;
import raye7.ayounis.com.raye7task.ui.base.MvpView;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public interface MainMvpView extends MvpView {

    void updateArticleList(List<Article> contactUsList);

}
