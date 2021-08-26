package com.project.graduatepj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Waiting extends AppCompatActivity {
    SurfaceView surfaceView;
    TextView textView, txt;
    private TextView show;
    private TextView input;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    String paitentNumber, wistNumber;
    int cnt = 0;
    Bundle bundle = new Bundle();
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        input = findViewById(R.id.hint1);
        show = findViewById(R.id.hint2);
        // Button WaitingBack = (Button) findViewById(R.id.WaitingBack);
        Button NextButton = (Button) findViewById(R.id.nextbt);
        txt = (TextView) findViewById(R.id.hint1);
        getPermissionsCamera();

        Retrofit retrofit = new Retrofit.Builder() //api連接
                .baseUrl("http://106.105.167.136:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        input.addTextChangedListener(new TextWatcher() { //監視TextView是否有更變
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(input.getText().toString() != null){
                    Get_staff(retrofit,editable.toString());
                }
                show.setText(editable);
            }
        });

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                cnt++;
                switch (cnt) {
                    case 1:
                        txt.setText("手圈病歷號");
                        paitentNumber = textView.getText().toString();
                        intent.setClass(Waiting.this, Waiting2.class);
                        bundle.putString("paitentNumber", paitentNumber);
                        intent.putExtras(bundle);
                        break;
                    case 2:
                        wistNumber = textView.getText().toString();
                        intent.setClass(Waiting.this, Waiting2.class);
                        bundle.putString("wistNumber", wistNumber);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                }

            }

        });

//        WaitingBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cnt--;
//                switch (cnt) {
//                    case -1:
//                        Intent intent = new Intent();
//                        intent.setClass(Waiting.this, OperationHome.class);
//                        startActivity(intent);
//                        break;
//                    case 0:
//                        txt.setText("總表病歷號");
//                        break;
//                }
//            }
//        });
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
    public void Get_staff(Retrofit retrofit,String id){
        RESTfulApi jsonPlaceHolderApi = retrofit.create(RESTfulApi.class);
        Call<Staff_Api> call = jsonPlaceHolderApi.get_staff(id);
        call.enqueue(new Callback<Staff_Api>() {
            @Override
            public void onResponse(Call<Staff_Api> call, Response<Staff_Api> response) {
                if(!response.isSuccessful()){
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