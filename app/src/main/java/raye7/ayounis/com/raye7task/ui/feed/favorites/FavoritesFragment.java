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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import raye7.ayounis.com.raye7task.R;
import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.di.component.ActivityComponent;
import raye7.ayounis.com.raye7task.ui.base.BaseFragment;

/**
 * Created by janisharali on 25/05/17.
 */

public class FavoritesFragment extends BaseFragment implements
        FavoritesMvpView, FavoritesListAdapter.Callback {

    private static final String TAG = "FavoritesFragment";

    @Inject
    FavoritesMvpPresenter<FavoritesMvpView> mPresenter;


    FavoritesListAdapter mFavoritesAdapter = new FavoritesListAdapter(new ArrayList<Articles>());

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.news_recycler_view)
    RecyclerView mRecyclerView;

    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mFavoritesAdapter.setClickListener(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mFavoritesAdapter);
        mPresenter.onViewPrepared();


    }



    @Override
    public void getDataFromDatabase(List<Articles> articlesList) {
        if(articlesList.size() != 0) {
            mFavoritesAdapter.addItems(articlesList);
        }
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onArticleListClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mFavoritesAdapter.getItem(position).getUrl()));
        startActivity(browserIntent);
    }
}
