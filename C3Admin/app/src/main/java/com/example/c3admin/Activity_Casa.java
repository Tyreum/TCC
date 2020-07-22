package com.example.c3admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Casa extends AppCompatActivity {
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Search();
            }
        });
    }

    public void openActivity_Search() {
        Intent intent = new Intent(this, Activity_Search.class);
        startActivity(intent);
    }
}