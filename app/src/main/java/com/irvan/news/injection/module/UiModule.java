package com.irvan.news.injection.module;

import com.irvan.news.data.usecase.GetArticle;
import com.irvan.news.data.usecase.GetNews;
import com.irvan.news.ui.detail.DetailContract;
import com.irvan.news.ui.detail.DetailPresenter;
import com.irvan.news.ui.main.MainContract;
import com.irvan.news.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irvan on 06/06/2019.
 */
@Module
public class UiModule {

    @Provides
    DetailContract.Presenter providesDetailPresenter(GetArticle getArticle){
        return new DetailPresenter(getArticle);
    }

    @Provides
    MainContract.Presenter providesMainPresenter(GetNews getNews){
        return new MainPresenter(getNews);
    }
}
