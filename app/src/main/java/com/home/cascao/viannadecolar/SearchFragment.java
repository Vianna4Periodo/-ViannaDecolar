package com.home.cascao.viannadecolar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.home.cascao.viannadecolar.models.Passagem;

public class SearchFragment extends Fragment {

    private TextView origemText, destinoText, quantidadeText, dataSaidaText, dataChegadaText;
    private Button pesquisarButton;

    public SearchFragment() { }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void bind(View view) {
        pesquisarButton = view.findViewById(R.id.pesquisarButton);
        origemText = view.findViewById(R.id.origemText);
        destinoText = view.findViewById(R.id.destinoText);
        quantidadeText = view.findViewById(R.id.quantidadeText);

        pesquisarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesquisar();
            }
        });
    }

    private void pesquisar() {

        origemText.setError(null);
        destinoText.setError(null);
        quantidadeText.setError(null);

        String origem = origemText.getText().toString();
        String destino = destinoText.getText().toString();
        String quantidade = quantidadeText.getText().toString();

        if (TextUtils.isEmpty(origem)) {
            Toast.makeText(getContext(), "O campo origem e obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(destino)) {
            Toast.makeText(getContext(), "O campo destino e obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(quantidade)) {
            Toast.makeText(getContext(), "O campo quantidade e obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.putExtra("origem", origem);
        intent.putExtra("destino", destino);
        intent.putExtra("quantidade", quantidade);
        startActivity(intent);
    }

}
