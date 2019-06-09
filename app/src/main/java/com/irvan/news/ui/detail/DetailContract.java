package com.irvan.news.ui.detail;

import com.irvan.news.data.model.Article;

/**
 * Created by Irvan on 09/06/2019.
 */
public interface DetailContract {

    public interface View {

        void showLoading();
        void showContent(Article article);
        void showError();
    }

    public interface Presenter {

        void start(String SiteName, String UrlName, String UrlFriendlyDate, String UrlFriendlyHeadline);
        void onViewResumed(View view);
        void onViewPaused(View view);

    }
}
