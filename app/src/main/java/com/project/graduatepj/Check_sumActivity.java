package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Check_sumActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_sum);

        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_sumActivity.this,blood_homeActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_sumActivity.this,CheckActivity.class);
                startActivity(intent);
            }
        });
    }
}