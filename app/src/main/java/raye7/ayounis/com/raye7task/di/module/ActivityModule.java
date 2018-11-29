package raye7.ayounis.com.raye7task.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import raye7.ayounis.com.raye7task.di.ActivityContext;
import raye7.ayounis.com.raye7task.ui.feed.FeedMvpPresenter;
import raye7.ayounis.com.raye7task.ui.feed.FeedMvpView;
import raye7.ayounis.com.raye7task.ui.feed.FeedPagerAdapter;
import raye7.ayounis.com.raye7task.ui.feed.FeedPresenter;
import raye7.ayounis.com.raye7task.ui.feed.favorites.FavoritesMvpPresenter;
import raye7.ayounis.com.raye7task.ui.feed.favorites.FavoritesMvpView;
import raye7.ayounis.com.raye7task.ui.feed.favorites.FavoritesPresenter;
import raye7.ayounis.com.raye7task.ui.feed.news.NewsMvpPresenter;
import raye7.ayounis.com.raye7task.ui.feed.news.NewsMvpView;
import raye7.ayounis.com.raye7task.ui.feed.news.NewsPresenter;

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
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }
    @Provides
    NewsMvpPresenter<NewsMvpView> provideNewsMvpPresenter(
            NewsPresenter<NewsMvpView> presenter) {
        return presenter;
    }
    @Provides
    FavoritesMvpPresenter<FavoritesMvpView> provideFavoriteMvpPresenter(
            FavoritesPresenter<FavoritesMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }
    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}

