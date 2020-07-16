package com.test.githubapp.http;

import com.test.githubapp.data.Repo;
import com.test.githubapp.data.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private static final String HOST = "https://api.github.com/";

    public static final long PER_PAGE = 100;

    private static final long REPOS_PER_PAGE = 6;
    private static final String REPOS_SORT = "updated";

    private final GithubService gitHubService;

    private API() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
        httpClient.readTimeout(60, TimeUnit.SECONDS);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        this.gitHubService = retrofit.create(GithubService.class);
    }

    private static API instance;

    public synchronized static void init() {
        if (instance == null) {
            instance = new API();
        }
    }

    public synchronized static API getInstance() {
        return instance;
    }


    public Single<List<User>> getUsers() {
        return gitHubService.getUsers();
    }

    public Single<List<Repo>> getUserRepos(final String username) {
        return gitHubService.getUserRepos(username);
    }
}
