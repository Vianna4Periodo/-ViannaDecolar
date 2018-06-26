package com.home.cascao.viannadecolar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.home.cascao.viannadecolar.models.request.voo.VooCancelarPassagemRequest;
import com.home.cascao.viannadecolar.repository.ClienteRepository;
import com.home.cascao.viannadecolar.repository.VooRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalharPassagemActivity extends AppCompatActivity {

    private TextView origemText, destinoText, chegadaText, saidaText;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_passagem);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bind();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void bind() {
        Intent intent = getIntent();

        final int id = intent.getIntExtra(Intent.EXTRA_INDEX, 0);
        String origem = intent.getStringExtra("origem");
        String destino = intent.getStringExtra("destino");
        String chegada = intent.getStringExtra("chegada");
        String saida = intent.getStringExtra("saida");

        origemText = findViewById(R.id.origemText);
        destinoText = findViewById(R.id.destinoText);
        chegadaText = findViewById(R.id.chegadaText);
        saidaText = findViewById(R.id.saidaText);
        cancelButton = findViewById(R.id.cancelButton);

        origemText.setText(origem);
        destinoText.setText(destino);
        chegadaText.setText(chegada);
        saidaText.setText(saida);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VooRepository repository = new VooRepository();
                repository.cancelarPassagem(new VooCancelarPassagemRequest(id)).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(getApplicationContext(), "Passagem cancelada com sucesso.", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Não foi possível cancelar a passagem, tente novamente por favor.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
