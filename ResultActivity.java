package com.example.owner.android_yuma;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private static final String[] names = {
            "Taguchi","Fkoji","dotinstall"
    };

    private static final String[] prefectures = {
            "Ebisu","Shibuya","Tokyo"
    };

    private static final Integer[] photos = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<String> itemNames = new ArrayList<String>(Arrays.asList(names));
        List<Integer> itemImages = new ArrayList<Integer>(Arrays.asList(photos));
        List<String> itemPrefecture = new ArrayList<String>(Arrays.asList(prefectures));
        RecyclerView.Adapter mAdapter = new item(itemImages, itemNames, itemPrefecture);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.OnItemClickListener(new View.OnItemClickListener() {
            @Override
            public void onClick(View view, String name) {
                Intent intent = new Intent(this,ThirdActivity.class);
            }
        });
    }
    public void onClickButton (View view){
        finish();

    }
}