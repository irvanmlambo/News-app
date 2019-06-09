package com.irvan.news.data.remote;

import com.irvan.news.data.model.Article;
import com.irvan.news.data.model.News;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Irvan on 06/06/2019.
 */
public interface ApiService {

    @GET("news?format=json")
    Observable<List<News>> getNews();

    @GET("{SiteName}/{UrlName}/news/{UrlFriendlyDate}/{UrlFriendlyHeadline}?format=json")
    Observable<Article> getArticle(
            @Path("SiteName") String SiteName,
            @Path("UrlName") String UrlName,
            @Path("UrlFriendlyDate") String UrlFriendlyDate,
            @Path("UrlFriendlyHeadline") String UrlFriendlyHeadline
    );
}
