package com.test.githubapp.ui.activity.main;

import com.test.githubapp.GithubApp;
import com.test.githubapp.base.BasePresenter;
import com.test.githubapp.http.GithubService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter extends BasePresenter<MainView>
{
    @Inject
    GithubService githubService;

    public MainPresenter(MainView mainView)
    {
        GithubApp.getDaggerComponent().inject(this);
        attachView(mainView);
    }

    public void loadUsers() {
        compositeDisposable.add(githubService
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getView()::loadResult, getView()::handleError));
    }
}
