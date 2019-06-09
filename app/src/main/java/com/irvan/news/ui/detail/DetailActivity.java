package com.irvan.news.ui.detail;

import android.os.Bundle;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.irvan.news.App;
import com.irvan.news.R;
import com.irvan.news.data.model.Article;

import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Irvan on 09/06/2019.
 */
public class DetailActivity extends FragmentActivity implements DetailContract.View {

    public static final String CATEGORY = "Category";
    public static final String URL_NAME = "UrlName";
    public static final String URL_FRIENDLY_DATE = "UrlFriendlyDate";
    public static final String URL_FRIENDLY_HEADLINE = "UrlFriendlyHeadline";

    @BindView(R.id.progressBar) ProgressBar loadingView;
    @BindView(R.id.content) NestedScrollView content;
    @BindView(R.id.headline) TextView headline;
    @BindView(R.id.date) TextView date;
    @BindView(R.id.thumbnail) ImageView thumbnail;
    @BindView(R.id.body) TextView body;
    @BindView(R.id.textView) TextView errorView;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Inject DetailContract.Presenter presenter;

    private String category;
    private String UrlName;
    private String UrlFriendlyDate;
    private String UrlFriendlyHeadline;

    public DetailActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        toolbar.setNavigationIcon(R.drawable.arrow_left);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        ((App)getApplication()).getAppComponent().inject(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            category = extras.getString(CATEGORY);
            UrlName = extras.getString(URL_NAME);
            UrlFriendlyDate = extras.getString(URL_FRIENDLY_DATE);
            UrlFriendlyHeadline = extras.getString(URL_FRIENDLY_HEADLINE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onViewPaused(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewResumed(this);
        presenter.start(category,UrlName,UrlFriendlyDate,UrlFriendlyHeadline);
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
        showContent(false);
        errorView.setVisibility(View.GONE);
    }

    private void showContent(boolean show) {
        int visibility = show ? View.VISIBLE : View.INVISIBLE;
        content.setVisibility(visibility);
    }

    @Override
    public void showContent(Article article) {

        headline.setText(article.getHeadline());
        date.setText(getFormattedDate(Long.valueOf(article.getDateCreated())));
        body.setText(Html.fromHtml(article.getBody()).toString());

        Glide.with(this)
                .load(article.getImageUrlLocal() + article.getLargeImageName())
                .into(thumbnail);


        loadingView.setVisibility(View.GONE);
        showContent(true);
        errorView.setVisibility(View.GONE);
    }

    private String getFormattedDate(long timestamp){
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(timestamp);
        return  DateFormat.format("yyyy-MM-dd HH:mm:ss", cal).toString();
    }

    @Override
    public void showError() {
        loadingView.setVisibility(View.GONE);
        showContent(false);
        errorView.setVisibility(View.VISIBLE);
    }
}
