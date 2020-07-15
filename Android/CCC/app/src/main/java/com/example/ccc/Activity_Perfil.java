package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Perfil extends AppCompatActivity {
    private Button mapPage;
    private Button searchPage;
    private Button alterarSenha;
    private Button sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perfil);

        mapPage = (Button) findViewById(R.id.mapPage);
        mapPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Maps();
            }
        });
        searchPage = (Button) findViewById(R.id.searchPage);
        searchPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Search();
            }
        });
        alterarSenha = (Button) findViewById(R.id.alterarSenha);
        alterarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Change();
            }
        });
        sair = (Button) findViewById(R.id.sair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Login();
            }
        });
    }
    public void openActivity_Maps(){
        Intent intent = new Intent(this, Activity_Maps.class);
        startActivity(intent);
    }
    public void openActivity_Search(){
        Intent intent = new Intent(this, Activity_Search.class);
        startActivity(intent);
    }
    public void openActivity_Change(){
        Intent intent = new Intent(this, Activity_Change.class);
        startActivity(intent);
    }
    public void openActivity_Login(){
        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
    }
}