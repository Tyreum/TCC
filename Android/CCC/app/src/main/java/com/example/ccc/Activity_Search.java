package com.example.ccc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity_Search extends AppCompatActivity {
    private Button mapPage;
    private Button profilePage;

    ListView search_cambio;
    ArrayAdapter<String> adapter;

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

        search_cambio = (ListView) findViewById(R.id.search_cambio);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.casas_cambio)));

        adapter = new ArrayAdapter<String>(
          Activity_Search.this,
          android.R.layout.simple_list_item_1,
          arrayList
        );

        search_cambio.setAdapter(adapter);

        ListView lista = (ListView) findViewById(R.id.search_cambio);
        final ArrayList<Casa> casas = adicionarCasas();
        ArrayAdapter adapter = new CasaAdapter(this, casas);
        lista.setAdapter(adapter);

        search_cambio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Activity_Search.this, Activity_Casa.class);
                intent.putExtra("nome", casas.get(i).getNomecasa());
                startActivity(intent);
                intent.putExtra("moeda", casas.get(i).getMoedascasa());
                startActivity(intent);
                intent.putExtra("imagem", casas.get(i).getImagemcasa());
                startActivity(intent);
            }
        });
    }

    private ArrayList<Casa> adicionarCasas() {
        ArrayList<Casa> casas = new ArrayList<Casa>();
        Casa e = new Casa("Ponto do Câmbio", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
                casas.add(e);
            e = new Casa("Ponto do Câmbio1", "Dolar 4.30, Euro 6.20", R.drawable.pontodocambio);
                casas.add(e);
            e = new Casa("Ponto do Câmbio2", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
                casas.add(e);
            e = new Casa("Ponto do Câmbio3", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
                casas.add(e);
            e = new Casa("Ponto do Câmbio4", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
            casas.add(e);
            e = new Casa("Ponto do Câmbio5", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
            casas.add(e);
            e = new Casa("Ponto do Câmbio6", "Dolar 5.30, Euro 6.20", R.drawable.pontodocambio);
            casas.add(e);
        return casas;
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