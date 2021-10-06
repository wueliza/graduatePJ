package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chemopm3 extends AppCompatActivity {
    private Button sendbt , upbt;
    private TextView staffTv , checkTv , chemoTv , mednameTv , medsumTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemopm3);
        Intent intent = this.getIntent();
        Bundle scan_result = intent.getExtras();
        String staff = scan_result.getString("staff_id");
        String check = scan_result.getString("check_id");
        String chemo = scan_result.getString("chemo_id");
        sendbt = (Button)findViewById(R.id.sendbt);
        upbt = findViewById(R.id.cpfrontbt);
        staffTv = findViewById(R.id.cpstaffTv);
        checkTv = findViewById(R.id.cpcheckTv);
        chemoTv = findViewById(R.id.cpchemoTv);
        mednameTv = findViewById(R.id.cpmedTv);
        medsumTv = findViewById(R.id.cpamountTv);

        staffTv.setText(staff);
        checkTv.setText(check);
        chemoTv.setText(chemo);

        sendbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nintent = new Intent();
                nintent.setClass(Chemopm3.this , Chemopm.class);
                startActivity(nintent);
            }
        });
        upbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uintent = new Intent();
                uintent.setClass(Chemopm3.this , Chemopm2.class);
                startActivity(uintent);
            }
        });
    }
}