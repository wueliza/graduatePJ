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
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collect2);

        Bundle patientNumber1BloodCollect3 = this.getIntent().getExtras();
        Bundle sampleNumberBloodCollect3 = this.getIntent().getExtras();
        Bundle collectorNumberBloodCollect3 = this.getIntent().getExtras();
        Bundle recheckNumberBloodCollect3 = this.getIntent().getExtras();

        String patientNumber1 = patientNumber1BloodCollect3.getString("patientNumber1BloodCollect3");
        String sampleNumber = sampleNumberBloodCollect3.getString("sampleNumberBloodCollect3");
        String collectorNumber = collectorNumberBloodCollect3.getString("collectorNumberBloodCollect3");
        String recheckNumber = recheckNumberBloodCollect3.getString("recheckNumberBloodCollect3");

   //     EditText patientNumberBox = (EditText) findViewById(R.id.patientNumber1Box);
   //     EditText sampleNumberBox = (EditText) findViewById(R.id.sampleNumberBox);
   //     EditText collectorNumberBox = (EditText) findViewById(R.id.collectorNumberBox);
   //     EditText recheckNumberBox = (EditText) findViewById(R.id.recheckNumberBox);

        TextView tv = (TextView) findViewById(R.id.patientNumber1Box);
        TextView tv2 = (TextView) findViewById(R.id.sampleNumberBox);
        TextView tv3 = (TextView) findViewById(R.id.collectorNumberBox);
        TextView tv4 = (TextView) findViewById(R.id.recheckNumberBox);

        tv.setText(patientNumber1);
        tv2.setText(sampleNumber);
        tv3.setText(collectorNumber);
        tv4.setText(recheckNumber);





        Button bt = (Button) findViewById(R.id.nextbt);
        Button bt2 = (Button) findViewById(R.id.frontbt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodCollect2.this,examine_homePage.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodCollect2.this,BloodCollect1.class);
                startActivity(intent);
            }
        });
    }
}