package com.test.githubapp.ui.activity.main;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.test.githubapp.GithubApp;
import com.test.githubapp.R;
import com.test.githubapp.base.BaseActivity;
import com.test.githubapp.data.User;
import com.test.githubapp.ui.adapter.UserAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity
        extends BaseActivity
        implements MainView
{
    private RecyclerView recyclerViewUsers;
    private UserAdapter userAdapter;
    private ProgressBar progressBarMain;
    private MainPresenter mainPresenter;


    @Override
    protected void initViews()
    {
        recyclerViewUsers = findViewById(R.id.list_of_users);
        userAdapter = new UserAdapter(R.layout.user_item);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));

        progressBarMain = findViewById(R.id.main_progress);
        mainPresenter = new MainPresenter(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onStart() {
        super.onStart();

        recyclerViewUsers.setAdapter(userAdapter);

        mainPresenter.loadUsers();

        recyclerViewUsers.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void loadResult(List<User> items) {
        progressBarMain.setVisibility(View.GONE);
        userAdapter.addItems(items);
    }

    @Override
    public void handleError(Throwable e) {
        Toast.makeText(this, "Error - " + e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.d("Error", "Error - " + e.getMessage());
    }
}
