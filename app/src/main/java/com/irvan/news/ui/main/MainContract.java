package com.irvan.news.ui.main;

import com.irvan.news.data.model.News;

import java.util.List;

/**
 * Created by Irvan on 06/06/2019.
 */
public interface MainContract {

    interface View {

        void showLoading(boolean isRefresh);
        void showContent(List<News> news, boolean isRefresh);
        void showError();
    }

    interface Presenter {

        void onViewStarted(View view);
        void onViewPaused(View view);
        void onPullToRefresh();
        void onScrollToBottom();
        void onViewResumed(View view);
    }
}
