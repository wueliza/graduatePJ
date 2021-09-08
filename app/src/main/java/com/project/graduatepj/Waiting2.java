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

        Bundle paitentNumbercheck = this.getIntent().getExtras();
        Bundle wistNumbercheck= this.getIntent().getExtras();
        Bundle ManCheckBox = this.getIntent().getExtras();

        String patientNumber = paitentNumbercheck.getString("paitentNumber");
        String wistNumber = wistNumbercheck.getString("wistNumber");
        String ManCheckNumber = ManCheckBox.getString("ManCheckBox");

        TextView tv = (TextView) findViewById(R.id.PatientNumberBox);
        TextView tv2 = (TextView) findViewById(R.id.wistNumberBox);
        TextView tv3 = (TextView) findViewById(R.id.ManCheckBox);

        tv.setText(patientNumber);
        tv2.setText(wistNumber);
        tv3.setText(ManCheckNumber);

        Button BackButton = (Button) findViewById(R.id.frontbt);

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