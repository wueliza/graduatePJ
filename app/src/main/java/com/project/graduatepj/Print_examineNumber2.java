package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Print_examineNumber2 extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    Intent intent;{
        intent = new Intent(); }
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

            bt = findViewById(R.id.nextbt);
            bt2 = findViewById(R.id.frontbt);


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