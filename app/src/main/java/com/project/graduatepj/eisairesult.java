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

public class eisairesult extends AppCompatActivity {
    private TextView staff_id , patient_id , eisai_id , result_tv;
    private Button completebt , upStepbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eisairesult);
        Intent intent = getIntent();
        staff_id = findViewById(R.id.staff_id);
        patient_id = findViewById(R.id.patient_id);
        eisai_id = findViewById(R.id.eisai_id);
        result_tv = findViewById(R.id.result_tv);
        completebt = findViewById(R.id.completebt);
        upStepbt = findViewById(R.id.upStep_bt);

        Bundle scan_result = intent.getExtras();
        String staff = scan_result.getString("staff_id");
        String patient = scan_result.getString("patient_id");
        String eisai = scan_result.getString("eisai_id");

        staff_id.setText(staff);
        patient_id.setText(patient);
        eisai_id.setText(eisai);

        //api連接
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.105.167.136:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Get_eisai(retrofit , eisai);

        completebt.setOnClickListener(this::complete);
        upStepbt.setOnClickListener(this::upStep);
    }

    private void upStep(View view) {
        Intent uintent = new Intent();
        uintent.setClass(eisairesult.this , eisaicheck.class);
        startActivity(uintent);
    }

    public void Get_eisai(Retrofit retrofit, String id) {
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Eisai_Api> call = jsonPlaceHolderApi.get_eisai(id); //A00010
        call.enqueue(new Callback<Eisai_Api>() {
            @Override
            public void onResponse(Call<Eisai_Api> call, Response<Eisai_Api> response) {
                if (!response.isSuccessful()) {
                    result_tv.setText("此id不存在，請重新掃描！");
                    return;
                }
                else {
                    String expire = response.body().getExpire();
                    result_tv.setText(expire);
                }
            }

            @Override
            public void onFailure(Call<Eisai_Api> call, Throwable t) { }
        });
    }

    private void complete(View v){
        Intent intent = new Intent();
        intent.setClass(eisairesult.this , gotofunction.class);
        startActivity(intent);
    }
}