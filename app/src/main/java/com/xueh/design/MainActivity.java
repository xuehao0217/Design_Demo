package com.xueh.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xueh.design.bottomsheet.BottomSheetActivity;
import com.xueh.design.coordinatorlayout.activity.CoordinatorLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_to_bottomsheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BottomSheetActivity.class));
            }
        });
        findViewById(R.id.tv_to_Coordinator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
            }
        });
    }
}
