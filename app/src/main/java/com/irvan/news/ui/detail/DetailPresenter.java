package com.irvan.news.ui.detail;

import android.util.Log;

import com.irvan.news.data.model.Article;
import com.irvan.news.data.usecase.GetArticle;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Irvan on 09/06/2019.
 */
public class DetailPresenter implements DetailContract.Presenter{

    private DetailContract.View view;
    private GetArticle getArticle;

    @Inject
    public DetailPresenter(GetArticle getArticle) {
        this.getArticle = getArticle;
    }

    @Override
    public void start(String SiteName, String UrlName, String UrlFriendlyDate, String UrlFriendlyHeadline) {
        view.showLoading();
        loadArticle(SiteName,UrlName,UrlFriendlyDate,UrlFriendlyHeadline);
    }

    @Override
    public void onViewResumed(DetailContract.View view) {
        attachedView(view);
    }

    @Override
    public void onViewPaused(DetailContract.View view) {
        detachView();
    }

    private void loadArticle(String SiteName, String UrlName, String UrlFriendlyDate, String UrlFriendlyHeadline){
        getArticle.execute(SiteName,UrlName,UrlFriendlyDate,UrlFriendlyHeadline).subscribe(new Subscriber<Article>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                defaultErrorHandling(e);
                view.showError();
            }

            @Override
            public void onNext(Article article) {
                if(hasViewAttached()){
                    view.showContent(article);
                }else{
                    view.showError();
                }
            }
        });
    }

    private void attachedView(DetailContract.View view) {
        this.view = view;
    }

    private void detachView() {
        this.view = null;
    }

    private boolean hasViewAttached() {
        return view != null;
    }

    private void defaultErrorHandling(Throwable e) {
       System.out.println(Log.getStackTraceString(e));
    }
}
