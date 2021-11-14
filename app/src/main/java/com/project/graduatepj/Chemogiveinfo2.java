package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Chemogiveinfo2 extends AppCompatActivity {
    private Button sendbt , backbt;
    private TextView pa_id ,pa_name , pa_gender , pa_bed , pa_bsa ,pa_height , pa_weight , pa_age;
    private TextView staffTv , checkTv , chemoTv;
    private RESTfulApi resTfulApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        setContentView(R.layout.activity_chemogiveinfo2);
        pa_id = findViewById(R.id.pa_id_g);
        pa_name = findViewById(R.id.pa_name_g);
        pa_gender = findViewById(R.id.pa_gender_g);
        pa_bed = findViewById(R.id.pa_bed_g);
        pa_bsa = findViewById(R.id.pa_bsa_g);
        pa_height = findViewById(R.id.pa_height_g);
        pa_weight = findViewById(R.id.pa_weight_g);
        pa_age = findViewById(R.id.pa_age_g);

        staffTv = findViewById(R.id.sTv_g);
        checkTv = findViewById(R.id.checkTV_g);
        chemoTv = findViewById(R.id.chemoTv_g);

        Bundle scan_result = intent.getExtras();
        String patient = scan_result.getString("givepatient_id");
        String staff = scan_result.getString("givestaff_id");
        String check = scan_result.getString("givecheck_id");
        String chemo = scan_result.getString("givechemo_id");

        pa_id.setText(patient);
        staffTv.setText(staff);
        checkTv.setText(check);
        chemoTv.setText(chemo);
        sendbt = (Button)findViewById(R.id.sendbt);
        sendbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Chemogiveinfo2.this , Chemopm.class);
                startActivity(intent);
            }
        });
        backbt = findViewById(R.id.BackButtoni);
        backbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Chemogiveinfo2.this , Chemogiveinfo.class);
                startActivity(intent);
            }
        });
        //api連接
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://140.136.151.75/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        resTfulApi = retrofit.create(RESTfulApi.class);
        Get_patient(retrofit, patient);
    }

    public void Get_patient(Retrofit retrofit, String id) {
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Patient_Api> call = resTfulApi.getOne(id); //A00010
        call.enqueue(new Callback<Patient_Api>() {
            @Override
            public void onResponse(Call<Patient_Api> call, Response<Patient_Api> response) {
                if (response.body()==null) {
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