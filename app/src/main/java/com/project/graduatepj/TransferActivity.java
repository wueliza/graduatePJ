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
import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransferActivity extends AppCompatActivity {
    Button bt;
    Button bt2;
    SurfaceView surfaceView;
        private RESTfulApi resTfulApi;
    TextView textView , step;

    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    Bundle bundle = new Bundle();
    private TextView show;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        show = findViewById(R.id.show);

        //相機製作
        getPermissionsCamera();

        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);

        textView=(TextView) findViewById(R.id.input);
        step = (TextView) findViewById(R.id.step);

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true)
                .build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(){
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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://140.136.151.75:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        resTfulApi = retrofit.create(RESTfulApi.class);

        textView.addTextChangedListener(new TextWatcher() { //監視editText是否有更變
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(textView.getText().toString() != null){
                    Get_staff(retrofit,editable.toString());
                }
                //show.setText(editable);
            }
        });

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
                        tv.setText("輸血作業-核血人員");
                        tv1.setText("核血人員編號");
                        tv2.setText("核血人員");
                        break;
                    case 2:
                        tv.setText("輸血作業-確認人員");
                        tv1.setText("確認人員編號");
                        tv2.setText("確認人員");
                        break;
                    case 3:
                        tv.setText("輸血作業-掃描血袋");
                        tv1.setText("掃描血袋");
                        tv2.setText("掃描血袋");
                        break;
                    case 4:
                        Intent intent = new Intent(TransferActivity.this,Transfer_sumActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    default:
                        tv.setText("輸血作業-病歷號");
                        tv1.setText("病歷號");
                        tv2.setText("病歷號");
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                switch (count){
                    case 1:
                        tv.setText("輸血作業-核血人員");
                        tv1.setText("核血人員編號");
                        tv2.setText("核血人員");
                        break;
                    case 2:
                        tv.setText("輸血作業-確認人員");
                        tv1.setText("確認人員編號");
                        tv2.setText("確認人員");
                        break;
                    case 3:
                        tv.setText("輸血作業-掃描血袋");
                        tv1.setText("掃描血袋");
                        tv2.setText("掃描血袋");
                        break;
                    case -1:
                        Intent intent = new Intent(TransferActivity.this,blood_homeActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        tv.setText("輸血作業-病歷號");
                        tv1.setText("病歷號");
                        tv2.setText("病歷號");
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
    private void Get_staff(Retrofit retrofit,String id) {
        Call<Patient_Api> patient = resTfulApi.getOne(id);
        Call<Staff_Api> staff = resTfulApi.get_staff(id);

        if(count == 0) {
            patient.enqueue(new Callback<Patient_Api>() {
                @Override
                public void onResponse(Call<Patient_Api> patient, Response<Patient_Api> response) {
                    if (response.body()==null) {
                        step.setText("此id不存在，請重新掃描病歷號！");
                        return ;
                    }
                    String name = response.body().getName();
                    show.setText(name);
                    step.setText("掃描成功，請按下一步");
                    bundle.putString("patient_num", id);
                }

                @Override
                public void onFailure(Call<Patient_Api> patient, Throwable t) {
                    show.setText(t.getMessage());
                }
            });
        }
        else {
            staff.enqueue(new Callback<Staff_Api>() {
                @Override
                public void onResponse(Call<Staff_Api> staff, Response<Staff_Api> response) {
                    if (response.body()==null) {
                        switch (count) {
                            case 1:
                                step.setText("此id不存在，請重新掃描核血人員編號！");
                                break;
                            case 2:
                                step.setText("此id不存在，請重新掃描確認人員！");
                                break;
                            case 3:
                                step.setText("此id不存在，請重新掃描血袋編號！");
                                break;
                            case -1:
                                break;
                            default:
                                bundle.putString("patient_num", show.getText().toString());
                        }
                        return;
                    }
                    String name = response.body().getName();
                    show.setText(name);
                    switch (count) {
                        case 1:
                            bundle.putString("confirm", show.getText().toString());
                            step.setText("掃描成功，請按下一步");
                            break;
                        case 2:
                            bundle.putString("check", show.getText().toString());
                            step.setText("掃描成功，請按下一步");
                            break;
                        case 3:
                            bundle.putString("scan", show.getText().toString());
                            step.setText("掃描成功，請按下一步");
                            break;
                        case -1:
                            break;
                        default:
                            bundle.putString("patient_num", show.getText().toString());
                    }
                }

                @Override
                public void onFailure(Call<Staff_Api> staff, Throwable t) {
                    show.setText("請掃描條碼");
                }
            });
        }
    }
}