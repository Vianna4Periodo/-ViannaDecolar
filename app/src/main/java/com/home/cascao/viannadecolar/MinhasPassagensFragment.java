package com.home.cascao.viannadecolar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.home.cascao.viannadecolar.adapters.PassagensListAdapter;
import com.home.cascao.viannadecolar.models.Cliente;
import com.home.cascao.viannadecolar.models.Passagem;
import com.home.cascao.viannadecolar.models.response.cliente.ClientePassagensResponse;
import com.home.cascao.viannadecolar.repository.ClienteRepository;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MinhasPassagensFragment extends Fragment {

    private Button loginButton, cadastrarButton;
    private LinearLayout loginView;
    private ListView passagensView;
    private SwipeRefreshLayout swipeContainer;

    private PassagensListAdapter passagensListAdapter = new PassagensListAdapter(new ArrayList<Passagem>());

    public MinhasPassagensFragment() {
    }

    public static MinhasPassagensFragment newInstance() {
        MinhasPassagensFragment fragment = new MinhasPassagensFragment();
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
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_minhas_passagens, container, false);
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
        loginButton = view.findViewById(R.id.loginButton);
        cadastrarButton = view.findViewById(R.id.cadastrarButton);
        loginView = view.findViewById(R.id.loginView);
        passagensView = view.findViewById(R.id.passagensView);
        swipeContainer = view.findViewById(R.id.swipeContainer);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CadastroActivity.class);
                startActivity(intent);
            }
        });

        passagensView.setAdapter(passagensListAdapter);
        passagensView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Passagem passagem = passagensListAdapter.get(position);

                Intent intent = new Intent(getContext(), DetalharPassagemActivity.class);
                intent.putExtra(Intent.EXTRA_INDEX, passagem.getId());
                intent.putExtra("origem", passagem.getVoo().getOrigem());
                intent.putExtra("destino", passagem.getVoo().getDestino());
                intent.putExtra("chegada", passagem.getVoo().getDataChegada());
                intent.putExtra("saida", passagem.getVoo().getDataSaida());

                startActivity(intent);
            }
        });

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    private void loadData() {
        Cliente cliente = Utils.getInstance().getCliente();

        if (cliente != null && loginView != null) {
            getActivity().setTitle("Minhas passagens");

            swipeContainer.setVisibility(View.VISIBLE);
            loginView.setVisibility(View.GONE);
            passagensView.setVisibility(View.VISIBLE);

            ClienteRepository repository = new ClienteRepository();
            repository.passagens(cliente).enqueue(new Callback<ClientePassagensResponse>() {
                @Override
                public void onResponse(Call<ClientePassagensResponse> call, Response<ClientePassagensResponse> response) {
                    passagensListAdapter.add(response.body().getPassagens());
                    swipeContainer.setRefreshing(false);
                }

                @Override
                public void onFailure(Call<ClientePassagensResponse> call, Throwable t) {
                    Toast.makeText(getContext(), "Não foi possível carregar a lista de passagens, tente novamente por favor.", Toast.LENGTH_SHORT).show();
                    swipeContainer.setRefreshing(false);

                }
            });

        } else {
            swipeContainer.setVisibility(View.GONE);
            getActivity().setTitle("Login");
        }

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}
