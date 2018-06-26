package com.home.cascao.viannadecolar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.home.cascao.viannadecolar.models.request.voo.VooComprarPassagemRequest;
import com.home.cascao.viannadecolar.models.response.voos.VooComprarPassagemResponse;
import com.home.cascao.viannadecolar.repository.VooRepository;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ComprarPassagemActivity extends AppCompatActivity {

    private TextView origemText, destinoText, chegadaText, saidaText, valorPassagemText;
    private EditText valorText;
    private EditText cartaoText;
    private Button comprarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_passagem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bind();
        setTitle("Comprar Passagem");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void bind() {
        Intent intent = getIntent();

        String origem = intent.getStringExtra("origem");
        String destino = intent.getStringExtra("destino");
        String chegada = intent.getStringExtra("chegada");
        String saida = intent.getStringExtra("saida");
        String valorPassagem = intent.getStringExtra("valorPassagem");

        origemText = findViewById(R.id.origemText);
        destinoText = findViewById(R.id.destinoText);
        chegadaText = findViewById(R.id.chegadaText);
        saidaText = findViewById(R.id.saidaText);
        comprarButton = findViewById(R.id.comprarButton);
        valorText = findViewById(R.id.valorText);
        cartaoText = findViewById(R.id.cartaoText);
        valorPassagemText = findViewById(R.id.valorPassagemText);

        origemText.setText(origem);
        destinoText.setText(destino);
        chegadaText.setText(chegada);
        saidaText.setText(saida);
        valorPassagemText.setText(valorPassagem);

        comprarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprar();
            }
        });
    }

    private void comprar() {
        Intent intent = getIntent();

        if (valorText == null || valorText.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "O campo valor e obrigatório.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (Utils.getInstance().getCliente() == null) {
            Toast.makeText(getApplicationContext(), "Para comprar uma passagem você precisa estar logado.", Toast.LENGTH_SHORT).show();
            return;
        }

        final int id = intent.getIntExtra(Intent.EXTRA_INDEX, 0);
        final int quantidade = Integer.valueOf(intent.getStringExtra("quantidade"));
        final int valor = Integer.valueOf(valorText.getText().toString());

        VooRepository repository = new VooRepository();
        repository.comprarPassagem(new VooComprarPassagemRequest(id, Utils.getInstance().getCliente().getId(), quantidade, 200)).enqueue(new Callback<VooComprarPassagemResponse>() {
            @Override
            public void onResponse(Call<VooComprarPassagemResponse> call, Response<VooComprarPassagemResponse> response) {
                if (response.body().getPassagens() == null || response.body().getPassagens().size() == 0) {
                    Toast.makeText(getApplicationContext(), "Você não pode ir nesse voo poiso mesmo já está lotado.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Passagem comprada com sucesso.", Toast.LENGTH_SHORT).show();
                }

                finish();
            }

            @Override
            public void onFailure(Call<VooComprarPassagemResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Não foi possível comprar, tente novamente mais tarde por favor.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
