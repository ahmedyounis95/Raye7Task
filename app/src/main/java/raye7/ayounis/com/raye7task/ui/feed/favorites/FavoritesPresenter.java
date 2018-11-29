/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package raye7.ayounis.com.raye7task.ui.feed.favorites;


import javax.inject.Inject;

import raye7.ayounis.com.raye7task.data.DataManager;
import raye7.ayounis.com.raye7task.ui.base.BasePresenter;

/**
 * Created by janisharali on 25/05/17.
 */

public class FavoritesPresenter<V extends FavoritesMvpView> extends BasePresenter<V>
        implements FavoritesMvpPresenter<V> {

    private int page = 1;

    @Inject
    public FavoritesPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getMvpView().getDataFromDatabase(getDataManager().getAllArticles());
        getMvpView().hideLoading();
    }



}
