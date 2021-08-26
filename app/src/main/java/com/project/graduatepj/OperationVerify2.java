package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OperationVerify2 extends AppCompatActivity {
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_verify2);

        Bundle paitentNumbercheckin3 = this.getIntent().getExtras();
        Bundle wistNumbercheckin3 = this.getIntent().getExtras();
        String KnifeNumber = paitentNumbercheckin3.getString("KnifeNumber");
        String wistNumberBox = wistNumbercheckin3.getString("wistNumberBox");
//        EditText KnifeNumberBox = (EditText)findViewById(R.id.KnifeNumberBox);
//        EditText patientNumberBox = (EditText)findViewById(R.id.patientNumberBox);
        String paitentNumber = wistNumbercheckin3.getString("paitentNumber");
        TextView tv = (TextView) findViewById(R.id.KnifeNumberBox);
        TextView tv2 = (TextView) findViewById(R.id.wistNumberBox);
        tv.setText(KnifeNumber);
        tv2.setText(wistNumberBox);
        Button BackButton = (Button) findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.setClass(OperationVerify2.this, OperationVerify.class);
                startActivity(intent);
            }
        });
        Button Upload = (Button) findViewById(R.id.Upload);

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(OperationVerify2.this, OperationHome.class);
                startActivity(intent);

            }
        });
    }
}