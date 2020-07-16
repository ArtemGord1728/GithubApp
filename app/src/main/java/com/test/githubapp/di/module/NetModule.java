package com.test.githubapp.di.module;


import com.test.githubapp.http.GithubService;
import com.test.githubapp.util.AppConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetModule
{
    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient httpClient)
    {
        return new Retrofit.Builder()
                .baseUrl(AppConstants.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    @Singleton
    @Provides
    GithubService provideGithubService(Retrofit retrofit)
    {
        return retrofit.create(GithubService.class);
    }

}
