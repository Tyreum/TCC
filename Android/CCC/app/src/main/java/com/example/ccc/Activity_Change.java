package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Change extends AppCompatActivity {
    private Button confirmSenha;
    private TextView txtRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_change);

        confirmSenha = (Button) findViewById(R.id.confirmSenha);
        confirmSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Maps();
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

    public void openActivity_Maps() {
        Intent intent = new Intent(this, Activity_Maps.class);
        startActivity(intent);
    }
    public void openActivity_Forgot(){
        Intent intent = new Intent(this, Activity_Forgot.class);
        startActivity(intent);
    }
}