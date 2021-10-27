package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_sumActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;

    TextView nurse,transfer,bloodnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_sum);

        Bundle bundle = getIntent().getExtras();
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);
        nurse = findViewById(R.id.nurse);
        transfer = findViewById(R.id.transfer);
        bloodnum = findViewById(R.id.bloodnum);


        String nurseman = bundle.getString("nurse");
        String transferman = bundle.getString("transfer");
        String bloodnumcount = bundle.getString("bloodnum");

        nurse.setText(nurseman);
        transfer.setText(transferman);
        bloodnum.setText(bloodnumcount);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_sumActivity.this,blood_homeActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_sumActivity.this,SignActivity.class);
                startActivity(intent);
            }
        });
    }
}