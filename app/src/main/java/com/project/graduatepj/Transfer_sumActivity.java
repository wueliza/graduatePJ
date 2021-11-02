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

public class Transfer_sumActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    TextView confirmman,checkman,paitent_Num,paitent_name,bloodtype,age,bednum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_sum);

        Bundle bundle = getIntent().getExtras();
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);
        confirmman = findViewById(R.id.confirm);
        checkman = findViewById(R.id.check);
        paitent_Num = findViewById(R.id.paitentNumber);
        paitent_name = findViewById(R.id.paitent_name);
        bloodtype = findViewById(R.id.bloodtype);
        age = findViewById(R.id.age);
        bednum = findViewById(R.id.bednum);

        String confirm = bundle.getString("confirm");
        String check = bundle.getString("check");
        String paitent_num = bundle.getString("patient_num");

        confirmman.setText(confirm);
        checkman.setText(check);
        paitent_Num.setText(paitent_num);

        Retrofit retrofit = new Retrofit.Builder() //api連接
                .baseUrl("http://140.136.151.75:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        if(paitent_Num.getText() != null)
            Get_staff(retrofit,paitent_Num.getText().toString());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Transfer_sumActivity.this,PagerActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Transfer_sumActivity.this,TransferActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Get_staff(Retrofit retrofit,String id){
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Patient_Api> call = jsonPlaceHolderApi.getOne(id); //A00010
        call.enqueue(new Callback<Patient_Api>() {
            @Override
            public void onResponse(Call<Patient_Api> call, Response<Patient_Api> response) {
                if(!response.isSuccessful()){
                    paitent_name.setText("找不到這位病人");
                    return;
                }
                else {
                    String getname = response.body().getName();
                    String getage = response.body().getAge();
                    String getbednum = response.body().getBedNum();
                    //String getbloodtype = response.body().getBloodType();

                    paitent_name.setText(getname);
                    age.setText(getage);
                    bednum.setText(getbednum);
                    //bloodtype.setText(getbloodtype);
                }
            }
            @Override
            public void onFailure(Call<Patient_Api> call, Throwable t) {
                paitent_name.setText("尚未掃病歷號");
            }
        });
    }
}