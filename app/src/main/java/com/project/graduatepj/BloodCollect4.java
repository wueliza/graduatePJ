package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BloodCollect4 extends AppCompatActivity {
    private Button next_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_collect4);


        Button button = (Button) findViewById(R.id.next_f);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BloodCollect4.this, examine_homePage.class);
                startActivity(intent);
                BloodCollect4.this.finish();
            }
        });


    }
}