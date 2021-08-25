package com.project.graduatepj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
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

public class Print_examineNumber2 extends AppCompatActivity {

        private Button bt1;
        private Button bt22;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_print_examine_number2);

            Bundle paitentNumber1BloodCollect3 = this.getIntent().getExtras();
            Bundle checkPaperNumberBloodCollect3 = this.getIntent().getExtras();

            String paitentNumber1 = paitentNumber1BloodCollect3.getString("paitentNumber1");
            String checkPaperNumber = checkPaperNumberBloodCollect3.getString("checkPaperNumber");

            EditText patientNumberBox = (EditText) findViewById(R.id.paitentNumber1Box);
            EditText checkPaperNumberBox = (EditText) findViewById(R.id.checkPaperNumberBox);

            TextView tv = (TextView) findViewById(R.id.paitentNumber1Box);
            TextView tv2 = (TextView) findViewById(R.id.checkPaperNumberBox);

            tv.setText(paitentNumber1);
            tv2.setText(checkPaperNumber);






            bt1 = findViewById(R.id.nextbt);
            bt22 = findViewById(R.id.frontbt);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.project.graduatepj.Print_examineNumber2.this,examine_homePage.class);
                    startActivity(intent);
                }
            });
            bt22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(com.project.graduatepj.Print_examineNumber2.this,Print_examineNumber1.class);
                    startActivity(intent);
                }
            });
        }
    }