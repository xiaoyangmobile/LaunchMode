package com.chengfayun.launchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleTaskActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        Button btnStandard = findViewById(R.id.task_btn_standard);
        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
        Button btnTop = findViewById(R.id.task_btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
        Button btnTask = findViewById(R.id.task_btn_task);
        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });
        Button btnInstance = findViewById(R.id.task_btn_instance);
        btnInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        tv = findViewById(R.id.task_tv_stack);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.setText(GetActivityInfo.get(this.getApplication()));
    }
}