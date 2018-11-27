package raye7.ayounis.com.raye7task.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raye7.ayounis.com.raye7task.R;
import raye7.ayounis.com.raye7task.data.model.Article;
import raye7.ayounis.com.raye7task.ui.base.BaseViewHolder;
import raye7.ayounis.com.raye7task.utils.CommonUtils;
/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public class ArticleListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mOnItemClickListener;


    private List<Article> mArticleResponseList;

    public ArticleListAdapter(List<Article> mArticleResponseList) {
        this.mArticleResponseList = mArticleResponseList;
    }

    public void setClickListener(Callback itemClickListener) {
        this.mOnItemClickListener= itemClickListener;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list, parent, false));
            case VIEW_TYPE_EMPTY:
                return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
            default:
                return new EmptyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if(mArticleResponseList != null && mArticleResponseList.size() > 0){
            return mArticleResponseList.size();
        }else{
            return 1;
        }
    }
    // convenience method for getting data at click position
    public Article getItem(int id) {
        return mArticleResponseList.get(id);
    }

    @Override
    public int getItemViewType(int position) {
        if(mArticleResponseList != null && mArticleResponseList.size() > 0)
        {
            return VIEW_TYPE_NORMAL;
        }else{
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void addItems(List<Article> articleList)
    {
        mArticleResponseList.addAll(articleList);
        notifyDataSetChanged();
    }
    public interface Callback {
        void onArticleListClick(int position);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.article_text)
        TextView companyTitleTxt;
        @BindView(R.id.article_image)
        ImageView companyImg;
        @BindView(R.id.txt_date)
        TextView dateTxt;
        @BindView(R.id.divider)
        View dividerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            final Article articleList = mArticleResponseList.get(position);
            if(articleList.getUrlToImage()!= null)
            {
                Glide.with(itemView.getContext())
                        .load(articleList.getUrlToImage())
                        .asBitmap()
                        .into(companyImg);
            }
            if(articleList.getDescription() != null)
            {
                companyTitleTxt.setText(articleList.getDescription());
            }
            if(articleList.getPublishedAt() != null)
            {
                dateTxt.setText(CommonUtils.getDate(articleList.getPublishedAt()));
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnItemClickListener != null)
                    {
                        mOnItemClickListener.onArticleListClick(getAdapterPosition());
                    }
                }
            });
        }

        @Override
        protected void clear() {
            companyImg.setImageDrawable(null);
            companyTitleTxt.setText("");
        }

    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.no_news_txt)
        TextView noInternetConnectionTxt;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }


    }

}
