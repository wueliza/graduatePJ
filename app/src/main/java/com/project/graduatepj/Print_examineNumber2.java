package com.project.graduatepj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Print_examineNumber2 extends AppCompatActivity {

    Intent intent = new Intent();
    TextView tv1, tv2 ;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_print_examine_number2);

            Bundle patientNumber1Check = this.getIntent().getExtras();
            Bundle checkPaperNumberCheck = this.getIntent().getExtras();

            String patientNumber1 = patientNumber1Check.getString("patientNumber1Check");
            String checkPaperNumber = checkPaperNumberCheck.getString("checkPaperNumberCheck");

            tv1 = (TextView) findViewById(R.id.patientNumber1Box);
            tv2 = (TextView) findViewById(R.id.checkPaperNumberBox);

            tv1.setText(patientNumber1);
            tv2.setText(checkPaperNumber);

            Button bt = (Button) findViewById(R.id.nextbt);
            Button bt2 = (Button) findViewById(R.id.frontbt);


            bt.setOnClickListener(v -> {
                Intent intent = new Intent(Print_examineNumber2.this,examine_homePage.class);
                startActivity(intent);
            });
            bt2.setOnClickListener(v -> {
                Intent intent = new Intent(Print_examineNumber2.this,Print_examineNumber1.class);
                startActivity(intent);
            });
        }
    }