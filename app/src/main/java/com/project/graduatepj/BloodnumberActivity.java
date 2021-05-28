package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class BloodnumberActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodnumber);

        bt = findViewById(R.id.nextbt);
        bt2 = findViewById(R.id.frontbt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodnumberActivity.this,Sign_sumActivity.class);
                /*Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);*/
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodnumberActivity.this,SignActivity.class);
                startActivity(intent);
            }
        });
    }
}