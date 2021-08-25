package com.project.graduatepj;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eisairesult extends AppCompatActivity {
    private TextView staff_id , patient_id , eisai_id , result_tv;
    private TextView resultTv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eisairesult);

        staff_id = findViewById(R.id.staff_id);
        patient_id = findViewById(R.id.patient_id);
        eisai_id = findViewById(R.id.eisai_id);
        result_tv = findViewById(R.id.result_tv);

        Bundle scan_result = this.getIntent().getExtras();
        String staff = scan_result.getString("staff_id");
        String patient = scan_result.getString("patient_id");
        String eisai = scan_result.getString("eisai_id");

        staff_id.setText(staff);
        patient_id.setText(patient);
        eisai_id.setText(eisai);


    }
}