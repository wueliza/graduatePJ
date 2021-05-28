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

public class SignActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    SurfaceView surfaceView;
    TextView textView;
    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        //相機製作
        getPermissionsCamera();

        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        textView=(TextView)findViewById(R.id.textView);
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this,barcodeDetector).setAutoFocusEnabled(true).build();
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

        TextView tv = (TextView)findViewById(R.id.title);
        TextView tv1 = (TextView)findViewById(R.id.input);
        TextView tv2 = (TextView)findViewById(R.id.show);
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);
        Bundle bundle = new Bundle();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                switch (count){
                    case 1:
                        tv.setText("血袋簽收-傳送人員");
                        tv1.setText("傳送人員編號");
                        tv2.setText("傳送人員:");
                        bundle.putString("transport",tv1.getText().toString());
                        break;
                    case 2:
                        tv.setText("血袋簽收-領血單號");
                        tv1.setText("領血單號");
                        tv2.setText("領血單號:");
                        bundle.putString("take",tv1.getText().toString());
                        break;
                    case 3:
                        Intent intent = new Intent(SignActivity.this,BloodnumberActivity.class);
                        intent.putExtras(bundle);   // 記得put進去，不然資料不會帶過去哦
                        startActivity(intent);
                        break;
                    default:
                        tv.setText("血袋簽收-護理人員");
                        tv1.setText("護理人員編號");
                        tv2.setText("護理人員:");
                        bundle.putString("nurse",tv1.getText().toString());
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                switch (count){
                    case 1:
                        tv.setText("血袋簽收-傳送人員");
                        tv1.setText("傳送人員編號");
                        tv2.setText("傳送人員:");
                        break;
                    case 2:
                        tv.setText("血袋簽收-領血單號");
                        tv1.setText("領血單號");
                        tv2.setText("領血單號:");
                        break;
                    case -1:
                        Intent intent = new Intent(SignActivity.this,blood_homeActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        tv.setText("血袋簽收-護理人員");
                        tv1.setText("護理人員編號");
                        tv2.setText("護理人員:");
                }
            }
        });
    }
    private void getPermissionsCamera() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
        }
    }
}