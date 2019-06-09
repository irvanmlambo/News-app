package com.irvan.news.data.usecase;

import com.irvan.news.data.model.Article;
import com.irvan.news.data.remote.ApiService;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Irvan on 08/06/2019.
 */
public class GetArticle {

    private ApiService apiService;

    @Inject
    public GetArticle(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<Article> execute(String SiteName, String UrlName, String UrlFriendlyDate, String UrlFriendlyHeadline){
        return apiService.getArticle(SiteName, UrlName, UrlFriendlyDate, UrlFriendlyHeadline)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
