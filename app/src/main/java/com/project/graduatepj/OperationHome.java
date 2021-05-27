package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OperationHome extends AppCompatActivity {
    private Button BackButton, CheckInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_home);

        BackButton = findViewById(R.id.BackButton);
        CheckInButton = findViewById(R.id.CheckInButton);
        BackButton.setOnClickListener(this::Home);
        CheckInButton.setOnClickListener(this::go_Check_in);

    }
    public void Home (View v){
        Intent intent = new Intent();
        intent.setClass(OperationHome.this , gotofunction.class);
        startActivity(intent);
    }
    public void go_Check_in (View v){
        Intent intent = new Intent();
        intent.setClass(OperationHome.this , CheckIn.class);
        startActivity(intent);
    }

}