package com.xueh.design.coordinatorlayout.activity;


import android.os.Bundle;

import com.xueh.design.R;

public class JianShuActivity extends BaseCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_hidden_toolbar);
        setUpCommonBackTooblBar(R.id.toolbar, "简书效果");
    }
}
