package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperationVerify2 extends AppCompatActivity {
    Intent intent = new Intent();
    TextView tv1, tv2, tv3, tv4, BirthdayBox, patientName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_verify2);

        Bundle paitentNumbercheck = this.getIntent().getExtras();
        Bundle wistNumbercheck = this.getIntent().getExtras();
        Bundle ManCheckBox = this.getIntent().getExtras();
        Bundle NameBox = this.getIntent().getExtras();
        Bundle birthday = this.getIntent().getExtras();

        String patientNumber = paitentNumbercheck.getString("KnifeNumberBox");
        String wistNumber = wistNumbercheck.getString("wistNumber");
        String ManCheckNumber = ManCheckBox.getString("ManCheckBox");
        String patientname = NameBox.getString("NameBox");
        String birth = birthday.getString("birth");

         tv1 = (TextView) findViewById(R.id.KnifeNumberBox);
         tv2 = (TextView) findViewById(R.id.wistNumberBox);
         tv3 = (TextView) findViewById(R.id.ManCheckBox);
         tv4 = (TextView) findViewById(R.id.ManCheckBox);

        patientName = findViewById(R.id.NameBox);
        BirthdayBox = findViewById(R.id.BirthdayBox);


        tv1.setText(patientNumber);
        tv2.setText(wistNumber);
        tv3.setText(ManCheckNumber);
        tv4.setText(birth);
        patientName.setText(patientname);

        Button frontbt = (Button) findViewById(R.id.frontbt);

        frontbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setClass(OperationVerify2.this, OperationVerify.class);
                startActivity(intent);
            }
        });
        Button Upload = (Button) findViewById(R.id.Upload);

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(OperationVerify2.this, OperationHome.class);
                startActivity(intent);

            }
        });
    }
}