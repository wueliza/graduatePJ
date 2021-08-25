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
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import java.io.IOException;

public class Print_examineNumber1 extends AppCompatActivity {
    private Button bt1;
    private Button bt22;
    SurfaceView surfaceView;
    TextView textView;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    String paitentNumber1,checkPaperNumber;
    int count=0;
    Bundle bundle = new Bundle();
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_examine_number1);

        getPermissionsCamera();

        //api連接
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.105.167.136:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //監視TextView是否有更變
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if (input.getText().toString() != null) {
                    Get_staff(retrofit, editable.toString());
                }
                show.setText(editable);
            }
        });
        //API結束 ， 下面還有

        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        textView=(TextView)findViewById(R.id.show);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(){
            @SuppressLint("MissingPermission")
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED)
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
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });

        TextView tv = (TextView)findViewById(R.id.titlee);
        TextView tv1 = (TextView)findViewById(R.id.inputt);
        TextView tv2 = (TextView)findViewById(R.id.showw);
        bt1 = findViewById(R.id.nextbt);
        bt22 = findViewById(R.id.frontbt);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                switch (count){
                    case 1:
                        tv.setText("列印檢體編號-檢驗單");
                        tv1.setText("請掃描檢驗單編號");
                        tv2.setText("檢驗單編號: ");
                        checkPaperNumber = textView.getText().toString();
                        intent.setClass(Print_examineNumber1.this, Print_examineNumber2.class);
                        bundle.putString("checkPaperNumber", checkPaperNumber);
                        intent.putExtras(bundle);
                        break;
                    case 2:
                        tv.setText("列印檢體編號-病歷號");
                        tv1.setText("請掃描手圈病歷號");
                        tv2.setText("手圈病歷號:");
                        paitentNumber1 = textView.getText().toString();
                        intent.setClass(Print_examineNumber1.this, Print_examineNumber2.class);
                        bundle.putString("paitentNumber1", paitentNumber1);
                        intent.putExtras(bundle);
                        break;
                }
            }
        });

        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                switch (count){
                    case -1:
                        tv.setText("列印檢體編號-檢驗單");
                        tv1.setText("請掃描檢驗單編號");
                        tv2.setText("檢驗單編號: ");
                        intent.setClass(Print_examineNumber1.this, examine_homePage.class);

                        break;
                    case 0:
                        Intent intent = new Intent();
                        tv.setText("列印檢體編號-病歷號");
                        tv1.setText("請掃描手圈病歷號");
                        tv2.setText("手圈病歷號:");
                        startActivity(intent);
                        break;

                }
            }
        });
    }
    private void getPermissionsCamera() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }
    }
    public void Get_staff(Retrofit retrofit, String id) {

        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Staff_Api> call = jsonPlaceHolderApi.get_staff(id); //A00010
        call.enqueue(new Callback<Staff_Api>() {
            @Override
            public void onResponse(Call<Staff_Api> call, Response<Staff_Api> response) {
                if (!response.isSuccessful()) {
                    show.setText("找不到這個id");
                    return;
                }
                String name = response.body().getName();
                show.setText(name);
            }

            @Override
            public void onFailure(Call<Staff_Api> call, Throwable t) {
                show.setText("請掃描條碼");
            }
        });
    }

}



















