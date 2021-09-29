package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CheckIn2 extends AppCompatActivity {

    Intent intent = new Intent();
    TextView tv1, tv2, tv3, Birthday, Doctor, patientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in2);

        Bundle paitentNumbercheck = this.getIntent().getExtras();
        Bundle wistNumbercheck = this.getIntent().getExtras();
        Bundle ManCheckBox = this.getIntent().getExtras();
        Bundle NameBox = this.getIntent().getExtras();

        String patientNumber = paitentNumbercheck.getString("paitentNumbercheck");
        String wistNumber = wistNumbercheck.getString("paitentNumbercheck");
        String ManCheckNumber = ManCheckBox.getString("ManCheckBox");
        String patientname = NameBox.getString("NameBox");

        tv1 = (TextView) findViewById(R.id.PatientNumberBox);
        tv2 = (TextView) findViewById(R.id.wistNumberBox);
        tv3 = (TextView) findViewById(R.id.ManCheckBox);

        patientName = findViewById(R.id.NameBox);
//        BirthdayBox = findViewById(R.id.BirthdayBox);
//        DoctorBox = findViewById(R.id.DoctorBox);

        tv1.setText(patientNumber);
        tv2.setText(wistNumber);
        tv3.setText(ManCheckNumber);
        patientName.setText(patientname);


        Button frontbt = (Button) findViewById(R.id.frontbt);
        Button Upload = (Button) findViewById(R.id.Upload);


        frontbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setClass(CheckIn2.this, CheckIn.class);
                startActivity(intent);
            }
        });


        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(CheckIn2.this, OperationHome.class);
                startActivity(intent);
            }
        });
    }


}