package com.home.cascao.viannadecolar;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.home.cascao.viannadecolar.adapters.PassagensListAdapter;
import com.home.cascao.viannadecolar.adapters.VoosListAdapter;
import com.home.cascao.viannadecolar.models.Cliente;
import com.home.cascao.viannadecolar.models.Passagem;
import com.home.cascao.viannadecolar.models.Voo;
import com.home.cascao.viannadecolar.models.request.voo.VooSearchRequest;
import com.home.cascao.viannadecolar.models.response.cliente.ClientePassagensResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooSearchResponse;
import com.home.cascao.viannadecolar.repository.ClienteRepository;
import com.home.cascao.viannadecolar.repository.VooRepository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private ListView passagensView;
    private ProgressBar load;

    private VoosListAdapter voosListAdapter= new VoosListAdapter(new ArrayList<Voo>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bind();
        loadData();
    }

    private void bind() {
        load = findViewById(R.id.load);
        passagensView = findViewById(R.id.passagensView);
        passagensView.setAdapter(voosListAdapter);
        passagensView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Voo voo = voosListAdapter.get(position);

                Intent intent = new Intent(getApplicationContext(), ComprarPassagemActivity.class);
                intent.putExtra(Intent.EXTRA_INDEX, voo.getId());
                intent.putExtra("origem", voo.getOrigem());
                intent.putExtra("destino", voo.getDestino());
                intent.putExtra("chegada", voo.getDataChegada());
                intent.putExtra("saida", voo.getDataSaida());
                intent.putExtra("valorPassagem", String.valueOf(voo.getValor()));
                intent.putExtra("quantidade", getIntent().getStringExtra("quantidade"));

                startActivity(intent);
            }
        });
    }

    private void loadData() {
        setTitle("Pesquisa");

        load.setVisibility(View.VISIBLE);

        passagensView.setVisibility(View.VISIBLE);

        Intent intent = getIntent();

        String origem = intent.getStringExtra("origem");
        String destino = intent.getStringExtra("destino");
        String chegada = intent.getStringExtra("chegada");
        String saida = intent.getStringExtra("saida");

        VooRepository repository = new VooRepository();
        repository.search(new VooSearchRequest(origem, destino, chegada, saida)).enqueue(new Callback<VooSearchResponse>() {
            @Override
            public void onResponse(Call<VooSearchResponse> call, Response<VooSearchResponse> response) {
                voosListAdapter.add(response.body().getVoos());
                load.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<VooSearchResponse> call, Throwable t) {
                load.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Não foi possível completar a busca, tente novamente por favor.", Toast.LENGTH_SHORT).show();
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
