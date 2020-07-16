package com.test.githubapp.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repo implements Serializable {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String full_name;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("description")
    private String description;

    @SerializedName("stargazers_count")
    private long stargazers_count;

    @SerializedName("watchers_count")
    private long watchers_count;

    @SerializedName("language")
    private String programmingLanguage;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public long getStargazers_count() {
        return stargazers_count;
    }

    public long getWatchers_count() {
        return watchers_count;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
