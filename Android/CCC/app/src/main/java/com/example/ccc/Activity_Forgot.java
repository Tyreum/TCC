package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Forgot extends AppCompatActivity {
    private Button confirmCode;
    private Button sendEmail;

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

        sendEmail = (Button) findViewById(R.id.sendEmail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "E-mail enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openActivity_Login() {
        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
    }
}