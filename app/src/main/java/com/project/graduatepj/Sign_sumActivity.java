package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_sumActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    //Bundle bundleget = getIntent().getExtras();
    /*TextView tv = (TextView)findViewById(R.id.nurse);
    TextView tv1 = (TextView)findViewById(R.id.transport);
    TextView tv2 = (TextView)findViewById(R.id.take);*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_sum);

        //Bundle bundle = getIntent().getExtras();
        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);
        /*String nurse = bundle.getString("nurse");
        String transport = bundle.getString("transport");
        String take = bundle.getString("take");
        tv.setText(nurse);
        tv1.setText(transport);
        tv2.setText(take);*/

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_sumActivity.this,blood_homeActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_sumActivity.this,SignActivity.class);
                startActivity(intent);
            }
        });
    }
}