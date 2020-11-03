package com.chengfayun.launchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleInstanceActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        Button btnStandard = findViewById(R.id.instance_btn_standard);
        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
        Button btnTop = findViewById(R.id.instance_btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
        Button btnTask = findViewById(R.id.instance_btn_task);
        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });
        Button btnInstance = findViewById(R.id.instance_btn_instance);
        btnInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        tv = findViewById(R.id.instance_tv_stack);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(GetActivityInfo.get(this.getApplication()));
    }
}