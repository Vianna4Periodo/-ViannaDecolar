package com.home.cascao.viannadecolar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.home.cascao.viannadecolar.R;
import com.home.cascao.viannadecolar.models.Passagem;

import java.util.ArrayList;
import java.util.List;

public class PassagensListAdapter extends BaseAdapter {

    private List<Passagem> passagens = new ArrayList<>();

    public PassagensListAdapter(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    @Override
    public int getCount() {
        return passagens.size();
    }

    @Override
    public Object getItem(int position) {
        return passagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return passagens.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        Passagem passagem = passagens.get(position);
        View cell = LayoutInflater.from(context).inflate(R.layout.passagem_item_list, parent, false);

        TextView origem = cell.findViewById(R.id.origemText);
        TextView destino = cell.findViewById(R.id.destinoText);

        TextView saida = cell.findViewById(R.id.dataSaidaText);
        TextView chegada = cell.findViewById(R.id.dataChegadaText);

        origem.setText(passagem.getVoo().getOrigem());
        destino.setText(passagem.getVoo().getDestino());

        saida.setText(passagem.getVoo().getDataSaida());
        chegada.setText(passagem.getVoo().getDataChegada());

        return cell;
    }

    public void add(List<Passagem> passagens) {
        this.passagens = passagens;
        notifyDataSetChanged();
    }

    public Passagem get(int position) {
        return passagens.get(position);
    }

}
