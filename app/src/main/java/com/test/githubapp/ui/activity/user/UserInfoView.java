package com.test.githubapp.ui.activity.user;

import com.test.githubapp.data.Repo;

import java.util.List;

public interface UserInfoView
{
    void loadResult(List<Repo> items);

    void handleError(Throwable e);
}
