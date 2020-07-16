package com.test.githubapp.ui.activity.main;

import com.test.githubapp.data.User;

import java.util.List;

public interface MainView
{
    void loadResult(List<User> items);

    void handleError(Throwable e);
}
