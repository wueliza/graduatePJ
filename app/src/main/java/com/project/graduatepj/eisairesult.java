package com.project.graduatepj;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eisairesult extends AppCompatActivity {
    private TextView inspectorTv , patientTv , equipmentTv;
    private TextView resultTv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eisairesult);

        inspectorTv = findViewById(R.id.inspectorTv);
        patientTv = findViewById(R.id.patientTv);
        equipmentTv = findViewById(R.id.equipmentTv);
        resultTv2 = findViewById(R.id.resultTv2);
        eisaiData e = new eisaiData();

        inspectorTv.setText(e.getInspetors_num());
        patientTv.setText(e.getPatient_num());
        equipmentTv.setText(e.getEquipment());
    }
}