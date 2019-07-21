package raye7.ayounis.com.raye7task.ui.feed.news;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raye7.ayounis.com.raye7task.R;
import raye7.ayounis.com.raye7task.data.model.Articles;
import raye7.ayounis.com.raye7task.ui.base.BaseViewHolder;
import raye7.ayounis.com.raye7task.utils.CommonUtils;

/**
 * Created by Ahmed Younis on 11/27/2018.
 */
public class NewsListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private Callback mOnItemClickListener;
    private CheckboxOnItemSelectedListener checkboxOnItemSelectedListener;


    private List<Articles> mArticlesResponseList;

    public NewsListAdapter(List<Articles> mArticlesResponseList) {
        this.mArticlesResponseList = mArticlesResponseList;
    }

    public void setClickListener(Callback itemClickListener) {
        this.mOnItemClickListener = itemClickListener;
    }

    public void setCheckboxOnItemSelectedListener(CheckboxOnItemSelectedListener checkboxOnItemSelectedListener) {
        this.checkboxOnItemSelectedListener = checkboxOnItemSelectedListener;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_view, parent, false));
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
        if (mArticlesResponseList != null && mArticlesResponseList.size() > 0) {
            return mArticlesResponseList.size();
        } else {
            return 1;
        }
    }

    // convenience method for getting data at click position
    public Articles getItem(int id) {
        return mArticlesResponseList.get(id);
    }

    @Override
    public int getItemViewType(int position) {
        if (mArticlesResponseList != null && mArticlesResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void addItems(List<Articles> articlesList) {
        mArticlesResponseList.clear();
        mArticlesResponseList.addAll(articlesList);

        notifyDataSetChanged();
    }



    public interface Callback {
        void onArticleListClick(int position);
    }

    public class ViewHolder extends BaseViewHolder{


        @BindView(R.id.article_text)
        TextView newsTitleTxt;
        @BindView(R.id.article_image)
        ImageView newsImg;
        @BindView(R.id.txt_date)
        TextView dateTxt;
        @BindView(R.id.divider)
        View dividerView;
        @BindView(R.id.news_checkbox)
        CheckBox newsCheckbox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onBind(final int position) {
            super.onBind(position);

            final Articles articlesList = mArticlesResponseList.get(position);
            if (articlesList.getUrlToImage() != null) {
                Glide.with(itemView.getContext())
                        .load(articlesList.getUrlToImage())
                        .asBitmap()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(newsImg);
            }

            if (articlesList.getDescription() != null) {
                newsTitleTxt.setText(articlesList.getDescription());
            }
            if (articlesList.getPublishedAt() != null) {
                dateTxt.setText(CommonUtils.getDate(articlesList.getPublishedAt()));
            }
            if (articlesList.isChecked()) {
                newsCheckbox.setChecked(true);
            } else if (!articlesList.isChecked()) {
                newsCheckbox.setChecked(false);
            }


            newsCheckbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (newsCheckbox.isChecked()) {
                        articlesList.setChecked(true);
                        newsCheckbox.setChecked(true);
                        if (checkboxOnItemSelectedListener != null) {
                            checkboxOnItemSelectedListener.onItemSelected(mArticlesResponseList.get(position), true);
                        }
                    } else if (!newsCheckbox.isChecked()) {
                        articlesList.setChecked(false);
                        newsCheckbox.setChecked(false);
                        if (checkboxOnItemSelectedListener != null) {
                            checkboxOnItemSelectedListener.onItemSelected(mArticlesResponseList.get(position), false);
                        }
                    }
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onArticleListClick(getAdapterPosition());
                    }
                }
            });
        }

        @Override
        protected void clear() {
            newsImg.setImageDrawable(null);
            newsTitleTxt.setText("");
        }


    }


    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.no_news_txt)
        TextView noNewsToShowTxt;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }


    }

}
