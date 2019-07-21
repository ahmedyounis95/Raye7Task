package raye7.ayounis.com.raye7task.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import raye7.ayounis.com.raye7task.data.local.db.Dao.ArticleListDao;
import raye7.ayounis.com.raye7task.data.model.Articles;

@Database(entities = Articles.class, version = 3,exportSchema = false )
public abstract class AppDataBase extends RoomDatabase {

    public abstract ArticleListDao dbHelper();

}

