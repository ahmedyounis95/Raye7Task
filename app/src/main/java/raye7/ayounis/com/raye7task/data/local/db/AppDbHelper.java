package raye7.ayounis.com.raye7task.data.local.db;


import java.util.List;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.local.db.Dao.ArticleListDao;
import raye7.ayounis.com.raye7task.data.model.Articles;


public class AppDbHelper implements DbHelper {

  private ArticleListDao mArticleListDao;

  @Inject
  public AppDbHelper(ArticleListDao articleListDao) {
    this.mArticleListDao = articleListDao;
  }

  @Override
  public List<Articles> getAllArticles() {
    return mArticleListDao.getAllArticles();
  }

  @Override
  public void insert(List<Articles> articlesList) {
      mArticleListDao.insert(articlesList);
  }

  @Override
  public void remove(Articles articles) {
      mArticleListDao.remove(articles);
  }
}
