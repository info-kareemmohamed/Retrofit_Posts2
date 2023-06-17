package com.example.retrofit_posts.data;

import com.example.retrofit_posts.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
public Call<List<PostModel>> getpost();

}
