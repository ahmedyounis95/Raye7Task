package raye7.ayounis.com.raye7task.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import raye7.ayounis.com.raye7task.R;
import raye7.ayounis.com.raye7task.data.model.Article;
import raye7.ayounis.com.raye7task.ui.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainMvpView,ArticleListAdapter.Callback{

    int pastVisiblesItems, visibleItemCount, totalItemCount;
    boolean loading = true;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;
    @Inject
    ArticleListAdapter mArticleListAdapter;
    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.recycler_news)
    RecyclerView mArticleRecyclerView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        setContentView(R.layout.activity_main);
        setUnbinder(ButterKnife.bind(this));

        mPresenter.onStartApp();
        setUp();

    }



    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();

    }

    @Override
    protected void setUp() {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mArticleRecyclerView.setLayoutManager(mLinearLayoutManager);
        mArticleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mArticleRecyclerView.setAdapter(mArticleListAdapter);
        mArticleListAdapter.setClickListener(this);
        onLoadMore();
        mPresenter.onStartApp();
    }


    @Override
    public void updateArticleList(List<Article> articleList) {
        mArticleListAdapter.addItems(articleList);
    }


    public void onLoadMore(){
        mArticleRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = mLinearLayoutManager.getChildCount();
                    totalItemCount = mLinearLayoutManager.getItemCount();
                    pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            mPresenter.onStartApp();
                            mArticleListAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onArticleListClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mArticleListAdapter.getItem(position).getUrl()));
        startActivity(browserIntent);
    }
}
