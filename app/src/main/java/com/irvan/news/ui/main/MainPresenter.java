package com.irvan.news.ui.main;

import android.util.Log;

import com.irvan.news.data.model.News;
import com.irvan.news.data.usecase.GetNews;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Irvan on 06/06/2019.
 */
public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;

    private GetNews getNews;

    @Inject
    public MainPresenter(GetNews getNews) {
        this.getNews = getNews;
    }

    @Override
    public void onViewStarted(MainContract.View view) {
        attachedView(view);

        view.showLoading(false);
        loadNews();
    }

    @Override
    public void onViewPaused(MainContract.View view) {
        detachView();
    }

    @Override
    public void onPullToRefresh() {
        view.showLoading(true);
        loadNews();
    }

    @Override
    public void onScrollToBottom() {
        view.showLoading(true);
        loadNews();
    }

    @Override
    public void onViewResumed(MainContract.View view) {
        attachedView(view);
    }

    private void attachedView(MainContract.View view){
        this.view = view;
    }

    private void loadNews(){
        getNews.execute().subscribe(new Subscriber<List<News>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError();
                defaultErrorHandling(e);
            }

            @Override
            public void onNext(List<News> news) {
                view.showContent(news, false);
            }
        });
    }

    private void detachView(){
        this.view = null;
    }

    private void defaultErrorHandling(Throwable t){
        System.out.println(Log.getStackTraceString(t));
    }

}
