package raye7.ayounis.com.raye7task.data.local.db;

import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;

public interface DbHelper {

  List<Articles> getAllArticles();

  void insert(List<Articles> articlesList);

  void remove(Articles articles);

}
