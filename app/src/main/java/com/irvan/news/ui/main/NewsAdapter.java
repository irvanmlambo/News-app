package com.irvan.news.ui.main;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.irvan.news.R;
import com.irvan.news.data.model.News;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irvan on 06/06/2019.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    private Activity activity;
    private ItemClickListener itemClickListener;

    public NewsAdapter(List<News> newsList, Activity activity, ItemClickListener itemClickListener) {
        this.newsList = newsList;
        this.activity = activity;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News news = newsList.get(position);

        Glide.with(activity)
                .load(news.getImageUrlRemote() + news.getSmallImageName())
                .into(holder.thumbnail);


        holder.category.setText(news.getCategory());
        holder.headline.setText(news.getHeadline());
        holder.date.setText(getFormattedDate(Long.valueOf(news.getDateCreated())));
        holder.blurb.setText(news.getBlurb());

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(news.getCategory(),news.getUrlName(),news.getUrlFriendlyDate(),news.getUrlFriendlyHeadline()));
    }

    private String getFormattedDate(long timestamp){
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);
        return  DateFormat.format("yyyy-MM-dd", cal).toString();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void clear(){
        newsList.clear();
    }

    public void addAll(List<News> news){
        this.newsList.addAll(news);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;

        @BindView(R.id.category) TextView category;
        @BindView(R.id.headline) TextView headline;
        @BindView(R.id.date) TextView date;
        @BindView(R.id.thumbnail) ImageView thumbnail;
        @BindView(R.id.blurb) TextView blurb;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }
    }

    interface ItemClickListener {
        void onItemClick(
                String SiteName,
                String UrlName,
                String UrlFriendlyDate,
                String UrlFriendlyHeadline
        );
    }
}
