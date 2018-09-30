package com.example.owner.android_yuma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.jar.Attributes;

public class item extends RecyclerView.Adapter<item.ViewHolder>{
    private List<Integer> iImages;
    private List<String> iNames;
    private List<String> iPrefectures;
    private View.OnClickListener listener;

     static class ViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView textView;
         TextView prefectureView;

         ViewHolder(View v) {
             super(v);
             imageView = v.findViewById(R.id.image_view);
             textView = v.findViewById(R.id.text_view);
             prefectureView = v.findViewById(R.id.prefecture_view);
         }
     }
    item(List<Integer> itemImages, List<String> itemNames, List<String> itemPrefectures) {
        this.iImages = itemImages;
        this.iNames = itemNames;
        this.iPrefectures = itemPrefectures;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);
        return  new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imageView.setImageResource(iImages.get(position));
        holder.textView.setText(iNames.get(position));
        holder.prefectureView.setText(iPrefectures.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view) {
                listener.onClick(view);
            }
        });
    }

    public void setOnItemClickListener(View.OnClickListener listener){
         this.listener =listener;
    }

    @Override
    public int getItemCount() {
        return iNames.size();

    }
    static class CustomViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout linearLayout;
        final TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }

    }
}