package com.test.githubapp.ui.activity.user;

import com.test.githubapp.GithubApp;
import com.test.githubapp.base.BasePresenter;
import com.test.githubapp.data.User;
import com.test.githubapp.http.API;
import com.test.githubapp.http.GithubService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserInfoPresenter extends BasePresenter<UserInfoView>
{
    @Inject
    GithubService githubService;

    public UserInfoPresenter(UserInfoView userInfoView)
    {
        GithubApp.getDaggerComponent().inject(this);
        attachView(userInfoView);
    }

    public void loadRepos(User userItem) {
        compositeDisposable.add(githubService
                .getUserRepos(userItem.getLogin())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getView()::loadResult, getView()::handleError));
    }
}
