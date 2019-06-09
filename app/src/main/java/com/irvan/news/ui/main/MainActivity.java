package com.irvan.news.ui.main;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.irvan.news.App;
import com.irvan.news.R;
import com.irvan.news.data.model.News;
import com.irvan.news.ui.detail.DetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Irvan on 06/06/2019.
 */
public class MainActivity extends FragmentActivity
implements MainContract.View, SwipeRefreshLayout.OnRefreshListener, NewsAdapter.ItemClickListener {

    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView) RecyclerView contentView;
    @BindView(R.id.textView) View errorView;
    @BindView(R.id.progressBar) View loadingView;


    private NewsAdapter adapter;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication()).getAppComponent().inject(this);

        presenter.onViewStarted(this);
        setupContentView();
    }

    @OnClick(R.id.textView)
    void onClickErrorView() {
        presenter.onViewStarted(this);
    }

    @Override
    public void onRefresh() {
        presenter.onPullToRefresh();
    }

    @Override
    public void showLoading(boolean isRefresh) {
        if (isRefresh) {
            adapter.clear();
            if (!swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(true);
            }
        } else {
            loadingView.setVisibility(View.VISIBLE);
            contentView.setVisibility(View.GONE);
            errorView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showContent(List<News> news, boolean isRefresh) {
        if(adapter == null){
            adapter = new NewsAdapter(news, this, this);
            contentView.setAdapter(adapter);
        }else{
            if(isRefresh){
                adapter.clear();
            }

            adapter.addAll(news);
            adapter.notifyDataSetChanged();
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 1500);

        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        hideContent();
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(String SiteName, String UrlName, String UrlFriendlyDate, String UrlFriendlyHeadline) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("Category", SiteName);
        i.putExtra("UrlName", UrlName);
        i.putExtra("UrlFriendlyDate", UrlFriendlyDate);
        i.putExtra("UrlFriendlyHeadline", UrlFriendlyHeadline);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        presenter.onViewStarted(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onViewResumed(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onViewPaused(this);
    }

    private void hideContent() {
        swipeRefreshLayout.setRefreshing(false);
        loadingView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
    }

    private void setupContentView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        contentView.setLayoutManager(linearLayoutManager);
    }
}
