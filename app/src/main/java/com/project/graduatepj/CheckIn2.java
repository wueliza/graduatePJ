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
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckIn2 extends AppCompatActivity {

    Intent intent = new Intent();
    TextView tv1, tv2, tv3, BirthdayBox, Doctor, patientName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in2);

        Bundle paitentNumbercheck = this.getIntent().getExtras();
        Bundle wistNumbercheck = this.getIntent().getExtras();
        Bundle ManCheckBox = this.getIntent().getExtras();
        Bundle NameBox = this.getIntent().getExtras();
        Bundle BirthBox = this.getIntent().getExtras();

        String patientNumber = paitentNumbercheck.getString("ora4chart");
        String wistNumber = wistNumbercheck.getString("paitentNumbercheck");
        String ManCheckNumber = ManCheckBox.getString("ManCheckBox");
        String patientname = NameBox.getString("NameBox");


        tv1 = (TextView) findViewById(R.id.PatientNumberBox);
        tv2 = (TextView) findViewById(R.id.wistNumberBox);
        tv3 = (TextView) findViewById(R.id.ManCheckBox);

        patientName = findViewById(R.id.NameBox);
        BirthdayBox = findViewById(R.id.BirthdayBox);
//        DoctorBox = findViewById(R.id.DoctorBox);

        tv1.setText(patientNumber);
        tv2.setText(wistNumber);
        tv3.setText(ManCheckNumber);
        patientName.setText(patientname);


        Button frontbt = (Button) findViewById(R.id.frontbt);
        Button Upload = (Button) findViewById(R.id.Upload);

        Retrofit retrofit = new Retrofit.Builder() //api連接
                .baseUrl("http://140.136.151.75:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        if(tv1.getText()!=null)
            Get_staff(retrofit, tv1.getText().toString());

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



    public void Get_staff(Retrofit retrofit, String id) {
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Patient_Api> call = jsonPlaceHolderApi.getOne(id); //A00010
        call.enqueue(new Callback<Patient_Api>() {
            @Override
            public void onResponse(Call<Patient_Api> call, Response<Patient_Api> response) {
                if (!response.isSuccessful()) {
                    BirthdayBox.setText("無此資料");
                    return;
                } else {
                    String getBirthday = response.body().getBirth();


                    BirthdayBox.setText(getBirthday);

                }
            }

            @Override
            public void onFailure(Call<Patient_Api> call, Throwable t) {
                BirthdayBox.setText("尚未掃病歷號");
            }
        });
    }


}