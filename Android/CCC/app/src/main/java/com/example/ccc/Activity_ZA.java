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

public class Activity_ZA extends AppCompatActivity {
    private Button mapPage;
    private Button profilePage;
    private Button sortAZ;
    private Button sortZA;
    private Button sortMeMa;
    private Button sortMaMe;
    private EditText theFilter;

    ListView search_cambio;
    ArrayAdapter<String> adapter;

    String nome[]= {"","Ponto do Câmbio","Shoptur (Casa de Câmbio)","Cotação Câmbio","Travelex Confidence - Câmbio","Orion Câmbio - Unidade Daycoval Diadema - Shopping Praça da Moça",
            "Cambiar - Online Exchange Search","Sagitur Casa de Câmbio","Treviso - Money Exchange","Cotação Câmbio Exchange","Get Money Exchange Houses","Porto Turismo - Casa de Câmbio",
            "Forex Done - Casa de Câmbio","Confidence Câmbio","Providence Exchange Casa de Câmbio","Câmbio Paulistano | Casa de Câmbio em São Paulo","Get Money Exchange Houses",
            "Casa de Câmbio TOP DayPay Western Union","Money Exchange - PRIMECASH","Casa de Câmbio Marzo Exchange"};

    String valor[]= {"","5,82","5,79","5,77","5,68","5,65","5,61","5,58","5,52","5,51","5,50","5,48","5,46","5,42","5,41","5,40","5,39","5,37","5,33","5,30"};

    int image[]= {1,R.drawable.pontodocambio,R.drawable.shoptour,R.drawable.cotacao,R.drawable.travelex,R.drawable.orion,R.drawable.cambiar,R.drawable.exchange,R.drawable.sagitur,R.drawable.treviso,
            R.drawable.cotacao,R.drawable.getmoney,R.drawable.portoturismo,R.drawable.fx,R.drawable.confidence,R.drawable.providence,R.drawable.paulistano,R.drawable.getmoney,R.drawable.top,
            R.drawable.primecash,R.drawable.marzo};

    String contato[] = {"",
            "+55 (11) 2501-7914",
            "+55 (11) 55487788",
            "+55 (11) 3003-2180",
            "+55 (11) 98778-0448",
            "+55 (11) 4051-2388",
            "+55 (11) 4810-1690",
            "+55 (11) 5189-4800",
            "+55 (11) 5182-2420",
            "+55 (11) 3003-2180",
            "+55 (11) 3018-1880",
            "+55 (11) 97255-4398",
            "+55 (11) 2305-6799",
            "+55 (11) 98778-0448",
            "+55 (11) 4420-5229",
            "+55 (11) 96368-3999",
            "+55 (11) 3018-1880",
            "+55 (11) 4750-2816",
            "+55 (11) 2626-2428",
            "+55 (11) 2323-2950"};

    String endereco[] = {"","R. Frei Canísio, 108 - Vila Sofia, São Paulo - SP, 04671-240",
            "Av. das Nações Unidas, 22540 - Jurubatuba, São Paulo - SP, 04295-030",
            "Av. Giovanni Gronchi, 5819 Piso 1 - Loja 218 - Vila Andrade, São Paulo - SP, 05724-003",
            "Avenida Interlagos, 2255 Arco 149 - Jardim Marajoara, São Paulo - SP, 04661-200",
            "R. Manoel da Nóbrega, 640 - Jardim do Parque, Diadema - SP, 09910-720",
            "Av. Dr. Chucri Zaidan, 1550 - Chácara Santo Antônio, São Paulo - SP, 04583-110",
            "Av. Roque Petroni Júnior, 1089 - Avenida Roque Petroni Júnior - Jardim das Acacias, São Paulo - SP, 04707-900",
            "Av. Dr. Chucri Zaidan, 902 - 124/125 - Vila Cordeiro, São Paulo - SP, 04795-100",
            "Av. Giovanni Gronchi, 5819 Piso 1 - Loja 218 - Vila Andrade, São Paulo - SP, 05724-003",
            "Gendai - Piso da Praça de Alimentação ao lado do, R. Treze de Maio, 1947 - Bela Vista, São Paulo - SP, 01327-001",
            "Alameda dos Aicás, 434 - Indianópolis, São Paulo - SP, 04086-000",
            "Av. Pavão, 489 - Indianópolis, São Paulo - SP, 04516-011",
            "Avenida Presidente Juscelino Kubitschek, 2041 Loja 420A - 3º piso - Vila Olímpia, São Paulo - SP, 04543-011",
            "Rodovia Raposo Tavares, 23500 - Lageadinho, Cotia - SP, 06709-015",
            "Edifício Dacon - Av. Cidade Jardim, 400 - sala 1 - Jardim Paulistano, São Paulo - SP, 01454-901",
            "Shopping Ibirapuera, Av. Ibirapuera, 3103 - Indianópolis, São Paulo, 04082-010",
            "Avenida Paulista, 854 Loja - 25c - Piso Térreo - Bela Vista, São Paulo - SP, 01310-100",
            "Praça da Liberdade, 130 - Loja 10 - Liberdade, São Paulo - SP, 01503-010",
            "R. Rosa e Silva, 145 - Santa Cecilia, São Paulo - SP, 01230-030"};


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
        sortAZ = (Button) findViewById(R.id.sortAZ);
        sortAZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_AZ();
            }
        });
        sortMeMa = (Button) findViewById(R.id.sortMeMa);
        sortMeMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_MeMa();
            }
        });

        search_cambio = (ListView) findViewById(R.id.search_cambio);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.casas_cambio)));

        adapter = new ArrayAdapter<String>(
                Activity_ZA.this,
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
                Intent intent = new Intent(Activity_ZA.this, Activity_Casa.class);
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
        Casa e = new Casa(nome[8], valor[8], image[8], contato[8], endereco[8]);
        casas.add(e);
        e = new Casa(nome[4], valor[4], image[4], contato[4], endereco[4]);
        casas.add(e);
        e = new Casa(nome[2], valor[2], image[2], contato[2], endereco[2]);
        casas.add(e);
        e = new Casa(nome[7], valor[7], image[7], contato[7], endereco[7]);
        casas.add(e);
        e = new Casa(nome[14], valor[14], image[14], contato[14], endereco[14]);
        casas.add(e);
        e = new Casa(nome[11], valor[11], image[11], contato[11], endereco[11]);
        casas.add(e);
        e = new Casa(nome[1], valor[1], image[1], contato[1], endereco[1]);
        casas.add(e);
        e = new Casa(nome[5], valor[5], image[5], contato[5], endereco[5]);
        casas.add(e);
        e = new Casa(nome[18], valor[18], image[18], contato[18], endereco[18]);
        casas.add(e);
        e = new Casa(nome[16], valor[16], image[16], contato[16], endereco[16]);
        casas.add(e);
        e = new Casa(nome[10], valor[10], image[10], contato[10], endereco[10]);
        casas.add(e);
        e = new Casa(nome[12], valor[12], image[12], contato[12], endereco[12]);
        casas.add(e);
        e = new Casa(nome[9], valor[9], image[9], contato[9], endereco[9]);
        casas.add(e);
        e = new Casa(nome[3], valor[3], image[3], contato[3], endereco[3]);
        casas.add(e);
        e = new Casa(nome[13], valor[13], image[13], contato[13], endereco[13]);
        casas.add(e);
        e = new Casa(nome[17], valor[17], image[17], contato[17], endereco[17]);
        casas.add(e);
        e = new Casa(nome[19], valor[19], image[19], contato[19], endereco[19]);
        casas.add(e);
        e = new Casa(nome[15], valor[15], image[15], contato[15], endereco[15]);
        casas.add(e);
        e = new Casa(nome[6], valor[6], image[6], contato[6], endereco[6]);
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
    public void openActivity_AZ(){
        Intent intent = new Intent(this, Activity_AZ.class);
        startActivity(intent);
    }
    public void openActivity_MeMa(){
        Intent intent = new Intent(this, Activity_MeMa.class);
        startActivity(intent);
    }

}