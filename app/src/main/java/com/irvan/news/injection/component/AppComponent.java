package com.irvan.news.injection.component;

import com.irvan.news.data.remote.ApiService;
import com.irvan.news.injection.module.AppModule;
import com.irvan.news.injection.module.NetworkModule;
import com.irvan.news.injection.module.UiModule;
import com.irvan.news.ui.detail.DetailActivity;
import com.irvan.news.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Irvan on 06/06/2019.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
                UiModule.class
        }
)
public interface AppComponent {

    void inject(DetailActivity activity);
    void inject(MainActivity activity);

    ApiService apiService();
}
