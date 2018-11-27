package raye7.ayounis.com.raye7task.ui.base;

import android.support.annotation.StringRes;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
