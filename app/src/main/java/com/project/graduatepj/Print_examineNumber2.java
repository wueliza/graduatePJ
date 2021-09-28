package com.project.graduatepj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Print_examineNumber2 extends AppCompatActivity {

        private Button bt;
        private Button bt2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_print_examine_number2);

            Bundle paitentNumber1BloodCollect3 = this.getIntent().getExtras();
            Bundle checkPaperNumberBloodCollect3 = this.getIntent().getExtras();

            String paitentNumber1 = paitentNumber1BloodCollect3.getString("paitentNumber1");
            String checkPaperNumber = checkPaperNumberBloodCollect3.getString("checkPaperNumber");

     //       EditText patientNumberBox = (EditText) findViewById(R.id.patientNumber1Box);
     //       EditText checkPaperNumberBox = (EditText) findViewById(R.id.checkPaperNumberBox);

            TextView tv = (TextView) findViewById(R.id.patientNumber1Box);
            TextView tv2 = (TextView) findViewById(R.id.checkPaperNumberBox);

            tv.setText(paitentNumber1);
            tv2.setText(checkPaperNumber);






            bt = findViewById(R.id.nextbt);
            bt2 = findViewById(R.id.frontbt);

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.project.graduatepj.Print_examineNumber2.this,examine_homePage.class);
                    startActivity(intent);
                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.project.graduatepj.Print_examineNumber2.this,Print_examineNumber1.class);
                    startActivity(intent);
                }
            });
        }
    }