package com.irvan.news.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irvan on 06/06/2019.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Named("applicationContext")
    public Context providesApplication(){
        return application;
    }
}
