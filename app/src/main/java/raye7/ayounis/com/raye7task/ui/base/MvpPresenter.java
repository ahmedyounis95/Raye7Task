package raye7.ayounis.com.raye7task.ui.base;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(Throwable e);

}
