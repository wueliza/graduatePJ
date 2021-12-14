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


public class BloodCollect2 extends AppCompatActivity {

    Intent intent = new Intent();
    TextView tv1, tv2, tv3, tv4;
    private RESTfulApi resTfulApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collect2);

        Bundle patientNumber1Check = this.getIntent().getExtras();
        Bundle sampleNumberCheck = this.getIntent().getExtras();
        Bundle collectorNumberCheck = this.getIntent().getExtras();
        Bundle recheckNumberCheck = this.getIntent().getExtras();

        String patientNumber1 = patientNumber1Check.getString("patientNumber1Check");
        String sampleNumber = sampleNumberCheck.getString("sampleNumberCheck");
        String collectorNumber = collectorNumberCheck.getString("collectorNumberCheck");
        String recheckNumber = recheckNumberCheck.getString("recheckNumberCheck");

        tv1 = (TextView) findViewById(R.id.patientNumber1Box);
        tv2 = (TextView) findViewById(R.id.sampleNumberBox);
        tv3 = (TextView) findViewById(R.id.collectorNumberBox);
        tv4 = (TextView) findViewById(R.id.recheckNumberBox);

        tv1.setText(patientNumber1);
        tv2.setText(sampleNumber);
        tv3.setText(collectorNumber);
        tv4.setText(recheckNumber);

        Button bt = (Button) findViewById(R.id.nextbt);
        Button bt2 = (Button) findViewById(R.id.frontbt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post_checkoperation(tv1.getText().toString(), tv2.getText().toString(),tv3.getText().toString(), tv4.getText().toString());
                Intent intent = new Intent(BloodCollect2.this, examine_homePage.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodCollect2.this, BloodCollect1.class);
                startActivity(intent);
            }
        });
    }

    private void post_checkoperation(String qrChart, String bsno, String emid, String confirmId) {

        CheckOperationRecord checkOperationRecord = new CheckOperationRecord(qrChart, bsno, emid, confirmId);
        Call<CheckOperationRecord> call = resTfulApi.post_CheckOperationRecord(checkOperationRecord);

        call.enqueue(new Callback<CheckOperationRecord>() {
            @Override
            public void onResponse(Call<CheckOperationRecord> call, Response<CheckOperationRecord> response) {

            }

            @Override
            public void onFailure(Call<CheckOperationRecord> call, Throwable t) {

            }
        });
    }

    private void post_Operation(String ORA4_CHART, String OR_CHART, String Emid,  String Birth,String Name) {
        OperationRecord operationRecord = new OperationRecord(ORA4_CHART, OR_CHART, Emid, Birth,Name );
        Call<OperationRecord> call = resTfulApi.post_OperationRecord(operationRecord);

        call.enqueue(new Callback<OperationRecord>() {
            @Override
            public void onResponse(Call<OperationRecord> call, Response<OperationRecord> response) {

            }

            @Override
            public void onFailure(Call<OperationRecord> call, Throwable t) {

            }
        });
    }






}

