package raye7.ayounis.com.raye7task.data.local.db;

import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;

public interface DbHelper {

  List<Articles> getAllNews();

  List<Articles> getAllFavorites();

  void insertNews(List<Articles> articlesList);

  void update(boolean articles,int id);

}
