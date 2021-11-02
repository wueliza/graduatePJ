package com.project.graduatepj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Chemocheck2 extends AppCompatActivity {
    private Button sentbt;
    private TextView staffTv , checkTv , chemoTv;
    private TextView pa_id ,pa_name , pa_gender , pa_bed , pa_bsa ,pa_height , pa_weight , pa_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemocheck2);
        Intent intent = this.getIntent();
        pa_id = findViewById(R.id.pa_id);
        pa_name = findViewById(R.id.pa_name);
        pa_gender = findViewById(R.id.pa_gender);
        pa_bed = findViewById(R.id.pa_bed);
        pa_bsa = findViewById(R.id.pa_bsa);
        pa_height = findViewById(R.id.pa_height);
        pa_weight = findViewById(R.id.pa_weight);
        pa_age = findViewById(R.id.pa_age);

        staffTv = findViewById(R.id.sTv);
        checkTv = findViewById(R.id.checkTV);
        chemoTv = findViewById(R.id.chemoTv);

        Bundle scan_result = intent.getExtras();
        String staff = scan_result.getString("chemostaff_id");
        String check = scan_result.getString("chemocheck_id");
        String chemo = scan_result.getString("chemo_id");

        staffTv.setText(staff);
        checkTv.setText(check);
        chemoTv.setText(chemo);

        sentbt = (Button)findViewById(R.id.sendbt);
        sentbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.setClass(Chemocheck2.this , Chemopm.class);

                startActivity(intent);
            }
        });
        //api連接
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://140.136.151.75/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Get_patient(retrofit, "12");
    }
    public void Get_patient(Retrofit retrofit, String id) {
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Patient_Api> call = jsonPlaceHolderApi.getOne(id); //A00010
        call.enqueue(new Callback<Patient_Api>() {
            @Override
            public void onResponse(Call<Patient_Api> call, Response<Patient_Api> response) {
                if (!response.isSuccessful()) {
                    pa_id.setText("此id不存在");
                    return;
                }
                else {
                    //int id = response.body().getPatientNum();
                    String name = response.body().getName();
                    String gender = response.body().getSex();
                    String bed = response.body().getBedNum();
                    String BSA = response.body().getName();
                    String height = response.body().getHeight();
                    String weight = response.body().getWeight();
                    String age = response.body().getAge();
                    pa_id.setText(id);
                    pa_name.setText(name);
                    pa_gender.setText(gender);
                    pa_bed.setText(bed);
                    pa_bsa.setText(BSA);
                    pa_height.setText(height);
                    pa_weight.setText(weight);
                    pa_age.setText(age);
                }
            }

            @Override
            public void onFailure(Call<Patient_Api> call, Throwable t) {
                pa_id.setText("錯誤");
            }
        });
    }
}