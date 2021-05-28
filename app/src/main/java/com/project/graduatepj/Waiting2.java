package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Waiting2 extends AppCompatActivity {
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting2);
        Bundle paitentNumbercheckin3 = this.getIntent().getExtras();
        Bundle wistNumbercheckin3 = this.getIntent().getExtras();
        String patientNumber = paitentNumbercheckin3.getString("paitentNumber");
        String wistNumber = wistNumbercheckin3.getString("wistNumber");
        EditText patientNumberBox = (EditText)findViewById(R.id.patientNumberBox);
        EditText wistNumberBox = (EditText)findViewById(R.id.wistNumberBox);
        TextView tv = (TextView) findViewById(R.id.patientNumberBox);
        TextView tv2 = (TextView) findViewById(R.id.wistNumberBox);
        tv.setText(patientNumber);
        tv2.setText(wistNumber);

        Button BackButton = (Button) findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setClass(Waiting2.this, Waiting.class);
                startActivity(intent);
            }
        });

        Button Upload = (Button) findViewById(R.id.Upload);

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Waiting2.this, OperationHome.class);
                startActivity(intent);

            }
        });
    }
}