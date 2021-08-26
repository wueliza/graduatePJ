package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Chemocheck2 extends AppCompatActivity {
    private Button sentbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemogiveinfo2);
        sentbt = (Button)findViewById(R.id.sendbt);
        sentbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(Chemocheck2.this , Chemopm.class);

                startActivity(intent);
            }
        });
    }
}