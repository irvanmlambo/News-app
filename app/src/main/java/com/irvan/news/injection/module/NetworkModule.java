package com.irvan.news.injection.module;

import android.content.Context;

import com.irvan.news.data.remote.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.irvan.news.Constants.BASE_URL;

/**
 * Created by Irvan on 06/06/2019.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient, @Named("applicationContext")Context context){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ApiService providesApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
