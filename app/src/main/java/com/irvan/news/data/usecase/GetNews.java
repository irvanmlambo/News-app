package com.irvan.news.data.usecase;

import com.irvan.news.data.model.News;
import com.irvan.news.data.remote.ApiService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Irvan on 08/06/2019.
 */
public class GetNews {

    private ApiService apiService;

    @Inject
    GetNews(ApiService apiService){
        this.apiService = apiService;
    }

    public Observable<List<News>> execute(){
        return apiService.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
