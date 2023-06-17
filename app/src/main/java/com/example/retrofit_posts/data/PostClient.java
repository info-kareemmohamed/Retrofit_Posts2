package com.example.retrofit_posts.data;

import com.example.retrofit_posts.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private final static String BASE_URL ="https://jsonplaceholder.typicode.com/";
    private  PostInterface postInterface;
    private static PostClient Instance;


    private PostClient(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        postInterface=retrofit.create(PostInterface.class);

    }

    public static PostClient getInstance(){
        if(Instance==null){
            Instance=new PostClient();
        }
        return Instance;
    }

    public Call<List<PostModel>> getCall(){
        return postInterface.getpost();
    }


}
