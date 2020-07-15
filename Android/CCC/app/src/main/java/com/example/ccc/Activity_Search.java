package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Search extends AppCompatActivity {
    private Button mapPage;
    private Button profilePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);

        mapPage = (Button) findViewById(R.id.mapPage);
        mapPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Maps();
            }
        });
        profilePage = (Button) findViewById(R.id.profilePage);
        profilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Perfil();
            }
        });
    }
    public void openActivity_Maps(){
        Intent intent = new Intent(this, Activity_Maps.class);
        startActivity(intent);
    }
    public void openActivity_Perfil(){
        Intent intent = new Intent(this, Activity_Perfil.class);
        startActivity(intent);
    }
}