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
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class BloodCollect1 extends AppCompatActivity {
    Button bt;
    Button bt2;

    Bundle bundle = new Bundle();
    private TextView show;
    SurfaceView surfaceView;
    TextView textView;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    int count = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collect1);

        show = findViewById(R.id.show);
        getPermissionsCamera();

        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        textView=(TextView)findViewById(R.id.input);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
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
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>(){

            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode>detections) {
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


        //api連接
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://106.105.167.136:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //監視TextView是否有更變
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override

            public void afterTextChanged(Editable editable) {
                if (textView.getText().toString() != null) {
                    Get_staff(retrofit, editable.toString());
                }
                //show.setText(editable);
            }

        });
        //API結束 ， 下面還有



        TextView tv = (TextView)findViewById(R.id.title);
        TextView tv1 = (TextView)findViewById(R.id.input);
        TextView tv2 = (TextView)findViewById(R.id.show);
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                switch (count){
                    case 1:
                        tv.setText("採血/備血作業-檢體編號");
                        tv1.setHint("請掃描檢體編號");
                        tv2.setHint("檢體編號: ");
                        break;
                    case 2:
                        tv.setText("採血/備血作業-採檢員");
                        tv1.setHint("請掃描採檢員編號");
                        tv2.setHint("採檢員編號: ");
                        break;
                    case 3:
                        tv.setText("採血/備血作業-確認員");
                        tv1.setHint("請掃描確認員編號");
                        tv2.setHint("確認員編號: ");
                        break;
                    case 4:
                        Intent intent = new Intent(BloodCollect1.this,BloodCollect2.class);
                        startActivity(intent);
                        intent.putExtras(bundle);
                        break;
                    default:
                        tv.setText("採血/備血作業-病歷號");
                        tv1.setHint("請掃描病歷號");
                        tv2.setHint("病歷號： ");
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                switch (count){
                    case 1:
                        tv.setText("採血/備血作業-檢體編號");
                        tv1.setHint("請掃描檢體編號");
                        tv2.setHint("檢體編號: ");
                        break;
                    case 2:
                        tv.setText("採血/備血作業-採檢員");
                        tv1.setHint("請掃描採檢員編號");
                        tv2.setHint("採檢員編號: ");
                        break;
                    case 3:
                        tv.setText("採血/備血作業-確認員");
                        tv1.setHint("請掃描確認員編號");
                        tv2.setHint("確認員編號: ");
                        break;
                    case -1:
                        Intent intent = new Intent(BloodCollect1.this,examine_homePage.class);
                        startActivity(intent);
                        break;
                    default:
                        tv.setText("採血/備血作業-病歷號");
                        tv1.setHint("請掃描病歷號");
                        tv2.setHint("病歷號： ");


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
        Call<Patient_Api> patient_apiCall = jsonPlaceHolderApi.getOne(id);

        if (count == 0 || count == 1)  {
            patient_apiCall.enqueue(new Callback<Patient_Api>() {
                @Override
                public void onResponse(Call<Patient_Api> patient_apiCall1, Response<Patient_Api> response) {
                    if (!response.isSuccessful()) {
                        show.setText("找不到這個id");
                        return;
                    }
                    String name = response.body().getName();
                    show.setText(name);
                    show.setText("掃描成功，請按下一步");
                    bundle.putString("patientNumber1Check", id);
                }

                @Override
                public void onFailure(Call<Patient_Api> patient_apiCall1, Throwable t) {
                    show.setText("請掃描條碼");
                }
            });
        } else {
            call.enqueue(new Callback<Staff_Api>() {
                @Override
                public void onResponse(Call<Staff_Api> call, Response<Staff_Api> response) {
                    if (!response.isSuccessful()) {
                        show.setText("找不到這個id");
                        return;
                    }
                    String name = response.body().getName();
                    show.setText(name);
                    show.setText("掃描成功，請按下一步");

                    switch (count) {
                        case 1:
                            bundle.putString("confirm", show.getText().toString());
                            break;
                        case 2:
                            bundle.putString("check", show.getText().toString());
                            break;
                        case 3:
                            bundle.putString("scan", show.getText().toString());
                            break;
                        case -1:
                            break;
                        default:
                            bundle.putString("collectorNumberCheck", show.getText().toString());
                    }
                }


                @Override
                public void onFailure(Call<Staff_Api> call, Throwable t) {
                    show.setText("請掃描條碼");
                }
            });
        }

    }
}





























