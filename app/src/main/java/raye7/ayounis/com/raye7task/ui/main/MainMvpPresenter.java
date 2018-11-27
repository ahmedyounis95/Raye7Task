package raye7.ayounis.com.raye7task.ui.main;

import raye7.ayounis.com.raye7task.di.PerActivity;
import raye7.ayounis.com.raye7task.ui.base.MvpPresenter;
import raye7.ayounis.com.raye7task.ui.base.MvpView;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
@PerActivity
public interface MainMvpPresenter<V extends MainMvpView & MvpView> extends MvpPresenter<V> {

    void onStartApp();

}
