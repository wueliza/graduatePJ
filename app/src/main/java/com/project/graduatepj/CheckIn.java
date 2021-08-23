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
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class CheckIn extends AppCompatActivity {
    SurfaceView surfaceView;
    TextView textView, txt;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    String paitentNumber, wistNumber, checkMan;
    int cnt = 0;
    Bundle bundle = new Bundle();
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        Button CheckInBack = (Button) findViewById(R.id.CheckinBack);
        Button NextButton = (Button) findViewById(R.id.NextButton);
        txt = (TextView) findViewById(R.id.titleName);
        getPermissionsCamera();


        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                cnt++;
                switch (cnt) {
                    case 1:
                        txt.setText("手圈病歷號");
                        paitentNumber = textView.getText().toString();
                        intent.setClass(CheckIn.this, CheckIn2.class);
                        bundle.putString("paitentNumber", paitentNumber);
                        intent.putExtras(bundle);
                        break;

                    case 2:
                        txt.setText("檢驗員");
                        checkMan = textView.getText().toString();
                        intent.setClass(CheckIn.this, CheckIn2.class);
                        bundle.putString("checkMan", checkMan);
                        intent.putExtras(bundle);
                        break;

                    case 3:
                        wistNumber = textView.getText().toString();
                        intent.setClass(CheckIn.this, CheckIn2.class);
                        bundle.putString("wistNumber", wistNumber);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;

                }
            }
        });
        CheckInBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt--;
                switch (cnt) {
                    case -1:
                        Intent intent = new Intent();
                        intent.setClass(CheckIn.this, OperationHome.class);
                        startActivity(intent);
                        break;
                    case 0:
                        txt.setText("總表病歷號");
                        break;
                }
            }
        });
        surfaceView = (SurfaceView)

                findViewById(R.id.surfaceView);

        textView = (TextView)

                findViewById(R.id.textView);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .

                        setBarcodeFormats(Barcode.ALL_FORMATS).

                        build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().

                addCallback(new SurfaceHolder.Callback() {
                    @Override
                    public void surfaceCreated(@NonNull SurfaceHolder holder) {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                                != PackageManager.PERMISSION_GRANTED)
                            return;
                        try {
                            cameraSource.start(holder);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

                    }

                    @Override
                    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                        cameraSource.stop();
                    }
                });
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {

            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes = detections.getDetectedItems();
                if (qrCodes.size() != 0) {
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(qrCodes.valueAt(0).displayValue);

                        }
                    });
                }
            }
        });
    }

    private void getPermissionsCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }


}