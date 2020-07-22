package com.example.ccc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class CasaAdapter extends ArrayAdapter<Casa> {
    private final Context context;
    private final ArrayList<Casa> elementos;

    public CasaAdapter(Context context, ArrayList<Casa> elementos) {
        super(context, R.layout.casas, elementos);
        this.context = context;
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.casas, parent, false);

        //Nome da casa
        TextView nomecasa = (TextView) rowView.findViewById(R.id.nomecasa);
        nomecasa.setText(elementos.get(position).getNomecasa());

        //Moeda da casa
        TextView moedascasa = (TextView) rowView.findViewById(R.id.moedascasa);
        moedascasa.setText(elementos.get(position).getMoedascasa());

        //Imagem da casa
        ImageView imagemcasa = (ImageView) rowView.findViewById(R.id.imagemcasa);
        imagemcasa.setImageResource(elementos.get(position).getImagemcasa());

        return rowView;
    }


}
