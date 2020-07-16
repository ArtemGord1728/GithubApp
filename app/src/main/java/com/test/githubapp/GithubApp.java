package com.test.githubapp;

import android.app.Application;

import com.test.githubapp.di.DaggerComponent;
import com.test.githubapp.di.DaggerDaggerComponent;
import com.test.githubapp.di.module.NetModule;


public class GithubApp extends Application
{
    private static DaggerComponent daggerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        daggerComponent = DaggerDaggerComponent.builder()
                .netModule(new NetModule())
                .build();
    }

    public static DaggerComponent getDaggerComponent() {
        return daggerComponent;
    }
}
