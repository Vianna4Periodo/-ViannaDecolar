package com.home.cascao.viannadecolar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.home.cascao.viannadecolar.R;
import com.home.cascao.viannadecolar.models.Voo;

import java.util.ArrayList;
import java.util.List;

public class VoosListAdapter extends BaseAdapter {

    private List<Voo> voos = new ArrayList<>();

    public VoosListAdapter(List<Voo> voos) {
        this.voos = voos;
    }

    @Override
    public int getCount() {
        return voos.size();
    }

    @Override
    public Object getItem(int position) {
        return voos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return voos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        Voo voo = voos.get(position);
        View cell = LayoutInflater.from(context).inflate(R.layout.voo_item_list, parent, false);

        TextView origem = cell.findViewById(R.id.origemText);
        TextView destino = cell.findViewById(R.id.destinoText);

        TextView saida = cell.findViewById(R.id.dataSaidaText);
        TextView chegada = cell.findViewById(R.id.dataChegadaText);

        TextView valor = cell.findViewById(R.id.valorText);
        TextView capacidade = cell.findViewById(R.id.capacidadeText);

        origem.setText(voo.getOrigem());
        destino.setText(voo.getDestino());

        saida.setText(voo.getDataSaida());
        chegada.setText(voo.getDataChegada());

        valor.setText(String.valueOf(voo.getValor()));
        capacidade.setText(String.valueOf(voo.getCapacidadeMaxima()));

        return cell;
    }

    public void add(List<Voo> voos) {
        this.voos = voos;
        notifyDataSetChanged();
    }

    public Voo get(int position) {
        return voos.get(position);
    }

}
