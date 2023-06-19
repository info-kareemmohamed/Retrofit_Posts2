package com.example.retrofit_posts.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import android.os.Bundle;

import com.example.retrofit_posts.R;
import com.example.retrofit_posts.pojo.PostModel;
import com.example.retrofit_posts.recycler.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
PostViewModel postViewModel;
RecyclerView recyclerView;
RecyclerAdapter adapter;
List<PostModel> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initialize_recycler();
       initialize_ViewModel_And_onChanged();

    }
    private void initialize_recycler() {
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }


    private void initialize_ViewModel_And_onChanged() {

        postViewModel= new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPost();
        postViewModel.mutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> list) {
                adapter.setList(list);
            }
        });



    }


}