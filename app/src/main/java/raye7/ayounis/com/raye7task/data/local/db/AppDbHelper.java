package raye7.ayounis.com.raye7task.data.local.db;


import java.util.List;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.local.db.Dao.ArticleListDao;
import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.Favorites;


public class AppDbHelper implements DbHelper {

  private ArticleListDao mArticleListDao;

  @Inject
  public AppDbHelper(ArticleListDao articleListDao) {
    this.mArticleListDao = articleListDao;
  }

  @Override
  public List<Articles> getAllNews() {
    return mArticleListDao.getAllNews();
  }

  @Override
  public List<Articles> getAllFavorites() {
    return mArticleListDao.getAllFavorites();
  }

  @Override
  public void insertNews(List<Articles> articlesList) {
    mArticleListDao.insertNews(articlesList);
  }

  @Override
  public void insert(Favorites articlesList) {
      mArticleListDao.insertFavorites(articlesList);
  }

  @Override
  public void update(boolean articles,int id) {
    mArticleListDao.update(articles,id);
  }

  @Override
  public void removeNews() {
    mArticleListDao.removeNews();
  }

  @Override
  public void remove(String  articles) {
      mArticleListDao.remove(articles);
  }
}
