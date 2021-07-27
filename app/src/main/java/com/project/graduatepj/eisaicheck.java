package com.project.graduatepj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class eisaicheck extends AppCompatActivity {

    private SurfaceView surfaceView;
    private TextView hint1 , hint2;
    private CameraSource cameraSource;
    private BarcodeDetector barcodeDetector;
    private Button nextBt;
    private eisaiData data; //store data
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eisaicheck);
        getPermissionsCamera();             //取得相機權限

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 螢幕寬度（畫素）
        int height = metric.heightPixels;   // 螢幕高度（畫素）
        float density = metric.density;      // 螢幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 螢幕密度DPI（120 / 160 / 240）
        System.out.println("w = " + width + "\nh = " + height);
        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        hint1=(TextView)findViewById(R.id.hint1);
        hint2 = (TextView)findViewById(R.id.hint2);
        nextBt = (Button)findViewById(R.id.nextBt);
        nextBt.setOnClickListener(this::nextStep);
        hint1.setText("請掃描檢驗員員工編號條碼");

        barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA)
                        !=PackageManager.PERMISSION_GRANTED)
                    return;
                try{
                    cameraSource.start(holder);

                }catch (IOException e){
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

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>(){
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes=detections.getDetectedItems();
                if(qrCodes.size()!=0){
                    hint1.post(new Runnable() {
                        @Override
                        public void run() {
                            hint1.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });

    }

    private void nextStep(View V){
        if(count == 0){
            //show & store the scan result from the inspector_num
            data.setInspetors_num("1234");
            hint2.setText("請掃描病歷號條碼");
            count++;
        }
        else if(count == 1){
            //show & store the scan result from the inspector_num
            data.setEquipment("4567");
            hint2.setText("請掃描衛材條碼");
            nextBt.setText("傳送");
            count++;
        }
        else if(count == 2){
            data.setEquipment("7890");
            Intent intent = new Intent();
            intent.setClass(eisaicheck.this , com.project.graduatepj.eisairesult.class);
            startActivity(intent);
        }
    }

    private void getPermissionsCamera() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }
    }

}
