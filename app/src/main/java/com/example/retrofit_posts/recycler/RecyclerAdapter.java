package com.example.retrofit_posts.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_posts.R;
import com.example.retrofit_posts.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
List<PostModel> list;

    public RecyclerAdapter(List<PostModel>list){

this.list=list;
    }
    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        holder.AddData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setList(List<PostModel> list){
    this.list=list;
    notifyDataSetChanged();
    }

    public class RecyclerHolder extends  RecyclerView.ViewHolder{
      TextView textId,textTitle,textBody;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            textId=itemView.findViewById(R.id.Id);
            textTitle=itemView.findViewById(R.id.title);
            textBody=itemView.findViewById(R.id.body);
        }

     private void AddData(PostModel post){
            textId.setText(String.valueOf( post.getId()));
            textTitle.setText(post.getTitle());
            textBody.setText(post.getBody());
     }


    }
}
