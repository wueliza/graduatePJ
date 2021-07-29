package com.project.graduatepj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends AppCompatActivity {
    private Button loginBt;
    private EditText accEt , pwEt;
    private TextView loginHint;
    private Connection connection = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mssql ms = new mssql();
        connection = ms.ConnectionHelper();
        loginBt = findViewById(R.id.loginBt);
        accEt = findViewById(R.id.accEt);
        pwEt = findViewById(R.id.pwEt);
        loginHint = findViewById(R.id.loginHint);

        loginBt.setOnClickListener(this::login_check);

    }
    public void login_check(View v){

        if(connection != null){
            System.out.println("connect success!");
            String ac = accEt.getText().toString();
            String ps = pwEt.getText().toString();

            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from userlogin where user_account = '" + ac + "'");
                pwEt.setText("");
                if(!resultSet.next())
                    loginHint.setText("帳號錯誤");
                else{
                    String ma_ps = resultSet.getString(4);
                    if(ma_ps.equals(ps)){

                        loginHint.setText("成功登入");
                        /*
                        Intent intent = new Intent();
                        intent.setClass(login.this , shop.class);
                        startActivity(intent);
                        */
                    }
                    else
                        loginHint.setText("密碼錯誤");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else
            loginHint.setText("連線錯誤");
            System.out.println("connect failed");
    }
}