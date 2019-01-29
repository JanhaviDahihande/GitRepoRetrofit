package com.example.janhavi.gitretrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitClient{

    @GET("/users/{user}/repos")
    Call<List<GitRepo>> reposForUser(@Path("user") String user);
}