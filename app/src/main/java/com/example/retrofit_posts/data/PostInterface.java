package com.example.retrofit_posts.data;

import com.example.retrofit_posts.pojo.PostModel;

import java.util.List;



import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
public Single<List<PostModel>> getpost();

}
