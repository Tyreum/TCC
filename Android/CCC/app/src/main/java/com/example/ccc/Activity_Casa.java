package com.example.ccc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Casa extends AppCompatActivity {
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_casa);

        Intent intent = getIntent();

        //Nome da casa
        String parametro = (String) intent.getSerializableExtra("nome");
        TextView nome = (TextView) findViewById(R.id.nomecasa);
        nome.setText(parametro);

        //Moeda da casa
        String parametro2 = (String) intent.getSerializableExtra("moeda");
        TextView moeda = (TextView) findViewById(R.id.moedascasa);
        moeda.setText(parametro2);

        //Imagem da casa
        int parametro3 = (int) intent.getIntExtra("imagem", R.id.imagemcasa);
        ImageView imagem = (ImageView) findViewById(R.id.imagem_casa);
        imagem.setImageResource(parametro3);

        //Contato da casa
        String parametro4 = (String) intent.getSerializableExtra("contato");
        TextView contato = (TextView) findViewById(R.id.contatocasa);
        contato.setText(parametro4);

        //Endereço da casa
        String parametro5 = (String) intent.getSerializableExtra("endereço");
        TextView endereco = (TextView) findViewById(R.id.enderecocasa);
        endereco.setText(parametro5);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
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