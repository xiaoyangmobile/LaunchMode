package com.chengfayun.launchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StandardActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        Button btnStandard = findViewById(R.id.standard_btn_standard);
        btnStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
        Button btnTop = findViewById(R.id.standard_btn_top);
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
            }
        });
        Button btnTask = findViewById(R.id.standard_btn_task);
        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
            }
        });
        Button btnInstance = findViewById(R.id.standard_btn_instance);
        btnInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });

        tv = findViewById(R.id.standard_tv_stack);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("StandardActivity", "onResume");
        tv.setText(GetActivityInfo.get(this.getApplication()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("StandardActivity", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("StandardActivity", "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("StandardActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("StandardActivity", "onStop");
    }
}