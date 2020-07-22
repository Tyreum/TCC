package com.example.c3admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Forgot extends AppCompatActivity {
    private Button confirmCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forgot);

        confirmCode = (Button) findViewById(R.id.confirmCode);
        confirmCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Login();
            }
        });
    }

    public void openActivity_Login() {
        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
    }
}