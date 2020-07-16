package com.test.githubapp.di;


import com.test.githubapp.di.module.NetModule;
import com.test.githubapp.ui.activity.main.MainActivity;
import com.test.githubapp.ui.activity.main.MainPresenter;
import com.test.githubapp.ui.activity.user.UserInfoActivity;
import com.test.githubapp.ui.activity.user.UserInfoPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface DaggerComponent
{
    void inject(MainActivity mainActivity);

    void inject(UserInfoActivity userInfoActivity);


    void inject(UserInfoPresenter userInfoPresenter);

    void inject(MainPresenter mainPresenter);
}
