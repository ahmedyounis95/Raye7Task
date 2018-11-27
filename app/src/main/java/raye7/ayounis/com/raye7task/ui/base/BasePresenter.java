package raye7.ayounis.com.raye7task.ui.base;

import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.ui.base.MvpPresenter;
import raye7.ayounis.com.raye7task.ui.base.MvpView;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;

    private V mMvpView;
    @Inject
    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public DataManager getDataManager(){return mDataManager;}


    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public void handleApiError(Throwable e) {

    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }

    }
}
