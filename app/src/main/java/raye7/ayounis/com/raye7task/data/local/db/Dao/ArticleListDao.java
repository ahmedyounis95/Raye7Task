package raye7.ayounis.com.raye7task.data.local.db.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.data.model.Favorites;
import raye7.ayounis.com.raye7task.utils.AppConstants;


@Dao
public interface ArticleListDao {

    @Query("SELECT * FROM " + AppConstants.ARTICLES_TABLE_NAME )
    List<Articles> getAllNews();

    @Query("SELECT * FROM article INNER JOIN favorites ON article.id = article_id"  )
    List<Articles> getAllFavorites();


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNews(List<Articles> articlesList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavorites(Favorites articlesList);

    @Query("UPDATE article SET checked = :articles WHERE id = :id" )
    void update(boolean articles,int id);

    @Query("DELETE FROM " + AppConstants.ARTICLES_TABLE_NAME)
    void removeNews();

    @Query("DELETE FROM favorites WHERE article_id= :articles")
    void remove(String articles);

}
