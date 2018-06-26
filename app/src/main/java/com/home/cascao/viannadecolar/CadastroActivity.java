package com.home.cascao.viannadecolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.home.cascao.viannadecolar.models.Cliente;
import com.home.cascao.viannadecolar.models.request.cliente.ClienteLoginRequest;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteLoginResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteSaveResponse;
import com.home.cascao.viannadecolar.repository.ClienteRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private EditText nomeText;
    private EditText emailText;
    private EditText passwordText;
    private Button cadastrarButton;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bind();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void bind() {
        nomeText = findViewById(R.id.nomeText);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        load = findViewById(R.id.load);
        cadastrarButton = findViewById(R.id.cadastrarButton);

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastro();
            }
        });
    }

    private void cadastro() {
        load.setVisibility(View.VISIBLE);

        nomeText.setError(null);
        emailText.setError(null);
        passwordText.setError(null);

        String nome = nomeText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordText.setError(getString(R.string.error_invalid_password));
            focusView = passwordText;
            cancel = true;
        }

        if (TextUtils.isEmpty(nome)) {
            nomeText.setError(getString(R.string.error_field_required));
            focusView = nomeText;
            cancel = true;
        } else if (TextUtils.isEmpty(email)) {
            emailText.setError(getString(R.string.error_field_required));
            focusView = emailText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailText.setError(getString(R.string.error_invalid_email));
            focusView = emailText;
            cancel = true;
        }

        if (cancel) {
            load.setVisibility(View.GONE);
            focusView.requestFocus();
        } else {
            ClienteRepository repository = new ClienteRepository();

            Cliente cliente = new Cliente(nome, email);
            cliente.setPassword(password);

            repository.save(cliente).enqueue(new Callback<ClienteSaveResponse>() {
                @Override
                public void onResponse(Call<ClienteSaveResponse> call, Response<ClienteSaveResponse> response) {
                    Toast.makeText(getApplicationContext(), "Bem Vindo!", Toast.LENGTH_SHORT).show();
                    Utils.getInstance().setCliente(response.body().getCliente());
                    passwordText.clearFocus();
                    finish();
                }

                @Override
                public void onFailure(Call<ClienteSaveResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Não foi possível fazer o cadastro, tente novamente por favor.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 1;
    }

}
