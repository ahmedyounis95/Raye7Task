package raye7.ayounis.com.raye7task.ui.feed.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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


public class NewsFragment extends BaseFragment implements
        NewsMvpView, NewsListAdapter.Callback {

    private static final String TAG = "FavoritesFragment";

    int pastVisiblesItems, visibleItemCount, totalItemCount;
    boolean loading = true;

    @Inject
    NewsMvpPresenter<NewsMvpView> mPresenter;


    NewsListAdapter mNewsAdapter = new NewsListAdapter(new ArrayList<Articles>());

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.news_recycler_view)
    RecyclerView mRecyclerView;

    private CheckboxOnItemSelectedListener checkboxOnItemSelectedListener;

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
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
            mNewsAdapter.setClickListener(this);
            mNewsAdapter.setCheckboxOnItemSelectedListener(checkboxOnItemSelectedListener);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mNewsAdapter);
        mPresenter.onViewPrepared();
        checkboxOnItemSelectedListener = new CheckboxOnItemSelectedListener() {
            @Override
            public void onItemSelected(Articles articles, boolean checked) {
                if(checked){
                        mPresenter.update(checked,articles.getId());
                        Log.e("data inserted", "success");
                    }else {

                    mPresenter.update(checked,articles.getId());
                    Log.e("data removed", "success");

                }
            }



        };
        mNewsAdapter.setCheckboxOnItemSelectedListener(checkboxOnItemSelectedListener);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            mPresenter.onViewPrepared();
                            loading = false;
                            mNewsAdapter.notifyDataSetChanged();


                        }
                    }
                }
            }
        });

    }



    @Override
    public void updateArticles(List<Articles> articlesList) {
        mNewsAdapter.addItems(articlesList);
    }

    @Override
    public void changeLoading(boolean changeLoading) {
        loading = changeLoading;
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onArticleListClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mNewsAdapter.getItem(position).getUrl()));
        startActivity(browserIntent);
    }
}
