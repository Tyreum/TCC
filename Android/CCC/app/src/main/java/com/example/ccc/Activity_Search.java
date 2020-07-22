package com.example.ccc;

import android.content.Intent;
import android.icu.util.JapaneseCalendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity_Search extends AppCompatActivity {
    private Button mapPage;
    private Button profilePage;
    private EditText theFilter;

    ListView search_cambio;
    ArrayAdapter<String> adapter;

    /*
    String nome[] = {"Ponto do Câmbio","Shoptur (Casa de Câmbio)","Cotação Câmbio","Travelex Confidence - Câmbio","Orion Câmbio - Unidade Daycoval Diadema - Shopping Praça da Moça",
                     "Cambiar - Online Exchange Search","Sagitur Casa de Câmbio","Treviso - Money Exchange","Cotação Câmbio Exchange","Get Money Exchange Houses","Porto Turismo - Casa de Câmbio",
                     "Forex Done - Casa de Câmbio","Confidence Câmbio","Providence Exchange Casa de Câmbio","Câmbio Paulistano | Casa de Câmbio em São Paulo","Get Money Exchange Houses",
                     "Casa de Câmbio TOP DayPay Western Union","Money Exchange - PRIMECASH","Casa de Câmbio Marzo Exchange"};

    String valor[] = {"5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30","5,30"};

    int image[] = {R.drawable.pontodocambio,R.drawable.shoptour,R.drawable.cotacao,R.drawable.travelex,R.drawable.orion,R.drawable.cambiar,R.drawable.exchange,R.drawable.sagitur,R.drawable.treviso,
                   R.drawable.cotacao,R.drawable.getmoney,R.drawable.portoturismo,R.drawable.fx,R.drawable.confidence,R.drawable.providence,R.drawable.paulistano,R.drawable.getmoney,R.drawable.top,
                   R.drawable.primecash,R.drawable.marzo};

    String contato[] = {"(11) 2501-7914", "+55 (11) 55487788",};

    String endereco[] = {};
    */

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
                intent.putExtra("contato", casas.get(i).getContatocasa());
                startActivity(intent);
                intent.putExtra("endereço", casas.get(i).getEnderecocasa());
                startActivity(intent);
            }
        });
    }

    private ArrayList<Casa> adicionarCasas() {
        ArrayList<Casa> casas = new ArrayList<Casa>();
        Casa e = new Casa("Ponto do Câmbio", "5,30", R.drawable.pontodocambio, "(11) 2501-7914", "R. Frei Canísio, 108 - Vila Sofia, São Paulo - SP, 04671-240");
        casas.add(e);
        e = new Casa("Shoptur (Casa de Câmbio)", "5,30", R.drawable.shoptour, "+55 (11) 55487788", "Av. das Nações Unidas, 22540 - Jurubatuba, São Paulo - SP, 04295-030");
        casas.add(e);
        e = new Casa("Cotação Câmbio", "5,30", R.drawable.cotacao, "+55 3003-2180", "Av. Giovanni Gronchi, 5819 Piso 1 - Loja 218 - Vila Andrade, São Paulo - SP, 05724-003");
        casas.add(e);
        e = new Casa("Travelex Confidence - Câmbio", "5,30", R.drawable.travelex, "+55 (11) 98778-0448", "Avenida Interlagos, 2255 Arco 149 - Jardim Marajoara, São Paulo - SP, 04661-200");
        casas.add(e);
        e = new Casa("Orion Câmbio - Unidade Daycoval Diadema - Shopping Praça da Moça", "5,30", R.drawable.orion, "+55 (11) 4051-2388", "R. Manoel da Nóbrega, 640 - Jardim do Parque, Diadema - SP, 09910-720");
        casas.add(e);
        e = new Casa("Cambiar - Online Exchange Search", "5,30", R.drawable.cambiar, "+55 (11) 4810-1690", "Av. Dr. Chucri Zaidan, 1550 - Chácara Santo Antônio, São Paulo - SP, 04583-110");
        casas.add(e);
        e = new Casa("Sagitur Casa de Câmbio", "5,30", R.drawable.sagitur, "+55 (11) 5189-4800", "Av. Roque Petroni Júnior, 1089 - Avenida Roque Petroni Júnior - Jardim das Acacias, São Paulo - SP, 04707-900");
        casas.add(e);
        e = new Casa("Treviso - Money Exchange", "5,30", R.drawable.treviso, "+55 (11) 51822420", "Av. Dr. Chucri Zaidan, 902 - 124/125 - Vila Cordeiro, São Paulo - SP, 04795-100");
        casas.add(e);
        e = new Casa("Cotação Câmbio Exchange", "5,30", R.drawable.cotacao, "+55 3003-2180", "Av. Giovanni Gronchi, 5819 Piso 1 - Loja 218 - Vila Andrade, São Paulo - SP, 05724-003\n");
        casas.add(e);
        e = new Casa("Get Money Exchange Houses", "5,30", R.drawable.getmoney, "+55 (11) 3018-1880", "Gendai - Piso da Praça de Alimentação ao lado do, R. Treze de Maio, 1947 - Bela Vista, São Paulo - SP, 01327-001");
        casas.add(e);
        e = new Casa("Porto Turismo - Casa de Câmbio", "5,30", R.drawable.portoturismo, "+55 (11) 97255-4398", "Alameda dos Aicás, 434 - Indianópolis, São Paulo - SP, 04086-000");
        casas.add(e);
        e = new Casa("Forex Done - Casa de Câmbio", "5,30", R.drawable.fx, "+55 (11) 2305-6799", "Av. Pavão, 489 - Indianópolis, São Paulo - SP, 04516-011");
        casas.add(e);
        e = new Casa("Confidence Câmbio", "5,30", R.drawable.confidence, "+55 (11) 98778-0448", "Avenida Presidente Juscelino Kubitschek, 2041 Loja 420A - 3º piso - Vila Olímpia, São Paulo - SP, 04543-011");
        casas.add(e);
        e = new Casa("Providence Exchange Casa de Câmbio", "5,30", R.drawable.providence, "+55 (11) 4420-5229", "Rodovia Raposo Tavares, 23500 - Lageadinho, Cotia - SP, 06709-015");
        casas.add(e);
        e = new Casa("Câmbio Paulistano | Casa de Câmbio em São Paulo", "5,30", R.drawable.paulistano, "+55 (11) 96368-3999", "Edifício Dacon - Av. Cidade Jardim, 400 - sala 1 - Jardim Paulistano, São Paulo - SP, 01454-901");
        casas.add(e);
        e = new Casa("Get Money Exchange Houses", "5,30", R.drawable.getmoney, "+55 (11) 3018-1880", "Shopping Ibirapuera, Av. Ibirapuera, 3103 - Indianópolis, São Paulo, 04082-010");
        casas.add(e);
        e = new Casa("Casa de Câmbio TOP DayPay Western Union", "5,30", R.drawable.top, "+55 (11) 4750-2816", "Avenida Paulista, 854 Loja - 25c - Piso Térreo - Bela Vista, São Paulo - SP, 01310-100");
        casas.add(e);
        e = new Casa("Money Exchange - PRIMECASH", "5,30", R.drawable.primecash, "+55 (11) 2626-2428", "Praça da Liberdade, 130 - Loja 10 - Liberdade, São Paulo - SP, 01503-010");
        casas.add(e);
        e = new Casa("Casa de Câmbio Marzo Exchange", "5,30", R.drawable.marzo, "+55 (11) 2323-2950", "R. Rosa e Silva, 145 - Santa Cecilia, São Paulo - SP, 01230-030");
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