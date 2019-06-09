package com.irvan.news;

import android.app.Application;

import com.irvan.news.injection.component.AppComponent;
import com.irvan.news.injection.component.DaggerAppComponent;
import com.irvan.news.injection.module.AppModule;
import com.irvan.news.injection.module.NetworkModule;
import com.irvan.news.injection.module.UiModule;

/**
 * Created by Irvan on 06/06/2019.
 */
public class App extends Application{

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDaggerComponent();
    }

    private AppComponent initDaggerComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .uiModule(new UiModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
