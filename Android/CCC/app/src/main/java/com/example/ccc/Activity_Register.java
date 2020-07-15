package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Register extends AppCompatActivity {
    private Button edRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        edRegistrar = (Button) findViewById(R.id.edRegistrar);
        edRegistrar.setOnClickListener(new View.OnClickListener() {
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