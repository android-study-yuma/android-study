package com.example.owner.android_yuma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    public static final String INTENT_ITEM_KEY = "item";

    private static final List<ItemModel> models = new ArrayList<ItemModel>() {
        { add(new ItemModel(R.drawable.ic_launcher_foreground, "Taguchi", "Ebisu")); }
        { add(new ItemModel(R.drawable.ic_launcher_foreground, "Fkoji", "Shibuya")); }
        { add(new ItemModel(R.drawable.ic_launcher_foreground, "dotinstall", "Tokyo")); }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(models);
        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemModel model, View view) {
                Intent intent = new Intent(ResultActivity.this, ThirdActivity.class);
                intent.putExtra(INTENT_ITEM_KEY, model);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
    public void onClickButton (View view){
        finish();
    }
}