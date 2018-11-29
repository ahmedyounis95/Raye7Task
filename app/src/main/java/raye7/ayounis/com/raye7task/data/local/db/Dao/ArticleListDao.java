package raye7.ayounis.com.raye7task.data.local.db.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.utils.AppConstants;


@Dao
public interface ArticleListDao {

    @Query("SELECT * FROM " + AppConstants.ARTICLES_TABLE_NAME)
    List<Articles> getAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Articles> articlesList);

    @Delete
    void remove(Articles articles);

}
