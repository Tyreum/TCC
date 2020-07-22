package com.example.c3admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    private TextView txtRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Maps();
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Register();
            }
        });
        txtRecover = (TextView) findViewById(R.id.txtRecover);
        txtRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Forgot();
            }
        });
    }
    public void openActivity_Maps(){
        Intent intent = new Intent(this, Activity_Perfil.class);
        startActivity(intent);
    }
    public void openActivity_Register(){
        Intent intent = new Intent(this, Activity_Register.class);
        startActivity(intent);
    }
    public void openActivity_Forgot(){
        Intent intent = new Intent(this, Activity_Forgot.class);
        startActivity(intent);
    }
}