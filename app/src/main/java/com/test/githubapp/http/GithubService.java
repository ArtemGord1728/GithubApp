package com.test.githubapp.http;

import com.test.githubapp.data.Repo;
import com.test.githubapp.data.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService
{
    @GET("users")
    Single<List<User>> getUsers();

    @GET("users/{username}/repos")
    Single<List<Repo>> getUserRepos(
            @Path("username") final String username
    );
}
