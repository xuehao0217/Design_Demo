package com.xueh.design.coordinatorlayout.activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.xueh.design.R;
import com.xueh.design.coordinatorlayout.adapter.RecyclerAdapter;

import java.util.ArrayList;

public class HideToolBarActivity extends  BaseCompatActivity {
    private ArrayList<String> stringArrayList;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_hidden_toolbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setData(); //adding data to array list
        adapter = new RecyclerAdapter(this, stringArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void setData() {
        stringArrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            stringArrayList.add("Item " + (i + 1));
        }
    }

}
