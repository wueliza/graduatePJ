package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Check_sumActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_sum);
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);
        /*Bundle bundle = getIntent().getExtras();

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
        paitent_Num.setText(paitent_num);*/

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_sumActivity.this,blood_homeActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Check_sumActivity.this,confirmActivity.class);
                startActivity(intent);
            }
        });
    }
}