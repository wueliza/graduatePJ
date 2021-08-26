package com.project.graduatepj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BloodCollect2 extends AppCompatActivity {
    private Button bt1;
    private Button bt22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collect2);

        Bundle paitentNumber1BloodCollect3 = this.getIntent().getExtras();
        Bundle sampleNumberBloodCollect3 = this.getIntent().getExtras();
        Bundle collectorNumberBloodCollect3 = this.getIntent().getExtras();
        Bundle recheckNumberBloodCollect3 = this.getIntent().getExtras();

        String paitentNumber1 = paitentNumber1BloodCollect3.getString("paitentNumber1");
        String sampleNumber = sampleNumberBloodCollect3.getString("sampleNumber");
        String collectorNumber = sampleNumberBloodCollect3.getString("collectorNumber");
        String recheckNumber = sampleNumberBloodCollect3.getString("recheckNumber");

   //     EditText patientNumberBox = (EditText) findViewById(R.id.paitentNumber1Box);
   //     EditText sampleNumberBox = (EditText) findViewById(R.id.sampleNumberBox);
   //     EditText collectorNumberBox = (EditText) findViewById(R.id.collectorNumberBox);
   //     EditText recheckNumberBox = (EditText) findViewById(R.id.recheckNumberBox);

        TextView tv = (TextView) findViewById(R.id.paitentNumber1Box);
        TextView tv2 = (TextView) findViewById(R.id.sampleNumberBox);
        TextView tv3 = (TextView) findViewById(R.id.collectorNumberBox);
        TextView tv4 = (TextView) findViewById(R.id.recheckNumberBox);

        tv.setText(paitentNumber1);
        tv2.setText(sampleNumber);
        tv3.setText(sampleNumber);
        tv4.setText(sampleNumber);






        bt1 = findViewById(R.id.nextbt);
        bt22 = findViewById(R.id.frontbt);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodCollect2.this,examine_homePage.class);
                startActivity(intent);
            }
        });
        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodCollect2.this,BloodCollect1.class);
                startActivity(intent);
            }
        });
    }
}