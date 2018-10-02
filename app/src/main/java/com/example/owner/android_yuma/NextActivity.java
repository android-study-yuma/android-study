package com.example.owner.android_yuma;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    public static final String INTENT_ITEM_KEY = "item";

    private static final List<ItemModel> models = new ArrayList<ItemModel>() {
        { add(new ItemModel(R.mipmap.ic_launcher, "Taguchi", "Ebisu")); }
        { add(new ItemModel(R.mipmap.ic_launcher, "Fkoji", "Shibuya")); }
        { add(new ItemModel(R.mipmap.ic_launcher, "dotinstall", "Tokyo")); }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(models);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(ItemModel model, View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(INTENT_ITEM_KEY, model);
        startActivity(intent);
    }

    public void onClickButton (View view){
        finish();
    }
}