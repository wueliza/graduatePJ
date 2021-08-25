package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Chemopm3 extends AppCompatActivity {
    private Button sendbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemopm3);

        sendbt = (Button)findViewById(R.id.sendbt);

        sendbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(Chemopm3.this , Chemopm.class);

                startActivity(intent);
            }
        });
    }
}