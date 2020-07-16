package com.test.githubapp.ui.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.test.githubapp.R;
import com.test.githubapp.base.BaseActivity;
import com.test.githubapp.data.Repo;
import com.test.githubapp.data.User;
import com.test.githubapp.http.API;
import com.test.githubapp.http.HttpLoader;
import com.test.githubapp.ui.adapter.ReposAdapter;
import com.test.githubapp.util.AppConstants;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserInfoActivity
        extends BaseActivity
        implements UserInfoView
{
    private User userItem;
    private Intent intent;

    private TextView tv_bio;
    private TextView tv_login;
    private CircleImageView circleImageAvatar;

    private RecyclerView recyclerViewRepos;
    private ReposAdapter reposAdapter;

    private ProgressBar progressBarRepos;

    private UserInfoPresenter userInfoPresenter;


    @Override
    protected void initViews() {
        intent = getIntent();
        userItem = intent.getParcelableExtra(AppConstants.EXTRA_USER);

        recyclerViewRepos = findViewById(R.id.user_repos);
        reposAdapter = new ReposAdapter(R.layout.repo_item);

        progressBarRepos = findViewById(R.id.repos_loader_progress);

        tv_bio = findViewById(R.id.user_name);
        tv_login = findViewById(R.id.user_login);
        circleImageAvatar = findViewById(R.id.user_avatar);

        userInfoPresenter = new UserInfoPresenter(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void onStart() {
        super.onStart();

        tv_bio.setText(getString(R.string.bio_str, userItem.getHtml_url()));
        tv_login.setText(getString(R.string.login_str, userItem.getLogin()));

        Glide.with(this)
                .load(userItem.getAvatarUrl())
                .into(circleImageAvatar);

        recyclerViewRepos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRepos.setHasFixedSize(true);

        recyclerViewRepos.setAdapter(reposAdapter);
        userInfoPresenter.loadRepos(userItem);
    }

    @Override
    public void loadResult(List<Repo> items) {
        progressBarRepos.setVisibility(View.GONE);
        reposAdapter.addItems(items);
    }

    @Override
    public void handleError(Throwable e) {
        Toast.makeText(this, "Error - " + e.getMessage(), Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
}
