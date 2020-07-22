package com.example.c3admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Maps extends AppCompatActivity {
    private Button searchPage;
    private Button profilePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_maps);

        searchPage = (Button) findViewById(R.id.searchPage);
        searchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Search();
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
    public void openActivity_Search(){
        Intent intent = new Intent(this, Activity_Search.class);
        startActivity(intent);
    }
    public void openActivity_Perfil(){
        Intent intent = new Intent(this, Activity_Perfil.class);
        startActivity(intent);
    }
}