package com.example.retrofit_posts.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit_posts.data.PostClient;
import com.example.retrofit_posts.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> mutableLiveData=new MutableLiveData<>();
    private static final String TAG="POSTMPDEL";
    public void getPost(){
        Single<List<PostModel>> single=PostClient.getInstance().getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        single.subscribe(o -> mutableLiveData.setValue(o),e-> Log.d(TAG,e.getMessage()));
    }

}
