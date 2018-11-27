package raye7.ayounis.com.raye7task.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import raye7.ayounis.com.raye7task.data.model.Article;
import raye7.ayounis.com.raye7task.di.ActivityContext;
import raye7.ayounis.com.raye7task.ui.main.ArticleListAdapter;
import raye7.ayounis.com.raye7task.ui.main.MainMvpPresenter;
import raye7.ayounis.com.raye7task.ui.main.MainMvpView;
import raye7.ayounis.com.raye7task.ui.main.MainPresenter;

/**
 * Created by Ahmed Younis on 11/26/2018.
 */
@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    ArticleListAdapter provideContactUsListAdapter() {
        return new ArticleListAdapter(new ArrayList<Article>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}

