package com.home.cascao.viannadecolar;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.home.cascao.viannadecolar.models.request.cliente.ClienteLoginRequest;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteLoginResponse;
import com.home.cascao.viannadecolar.repository.ClienteRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bind();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void bind() {
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        load = findViewById(R.id.load);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        load.setVisibility(View.VISIBLE);

        emailText.setError(null);
        passwordText.setError(null);

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordText.setError(getString(R.string.error_invalid_password));
            focusView = passwordText;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
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
            repository.login(new ClienteLoginRequest(email, password)).enqueue(new Callback<ClienteLoginResponse>() {
                @Override
                public void onResponse(Call<ClienteLoginResponse> call, Response<ClienteLoginResponse> response) {
                    Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_SHORT).show();
                    Utils.getInstance().setCliente(response.body().getCliente());
                    passwordText.clearFocus();
                    finish();
                }

                @Override
                public void onFailure(Call<ClienteLoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Não foi possível fazer login, tente novamente por favor.", Toast.LENGTH_SHORT).show();
                    load.setVisibility(View.GONE);
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

