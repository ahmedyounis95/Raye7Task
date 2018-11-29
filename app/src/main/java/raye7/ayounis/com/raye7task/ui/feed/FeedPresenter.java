package raye7.ayounis.com.raye7task.ui.feed;


import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;
import raye7.ayounis.com.raye7task.ui.base.MvpView;


public class FeedPresenter<V extends MvpView> extends BasePresenter<V> implements
        FeedMvpPresenter<V> {

    private static final String TAG = "FeedPresenter";

    @Inject
    public FeedPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
