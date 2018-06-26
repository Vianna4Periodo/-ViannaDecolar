package com.home.cascao.viannadecolar.repository;

import com.home.cascao.viannadecolar.models.Cliente;
import com.home.cascao.viannadecolar.models.request.cliente.ClienteLoginRequest;
import com.home.cascao.viannadecolar.models.request.cliente.ClienteValidarCartaoRequest;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteLoginResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClientePassagensResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteSaveResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteValidarCartaoResponse;
import com.home.cascao.viannadecolar.network.APIClient;
import com.home.cascao.viannadecolar.network.ClienteDataService;

import retrofit2.Call;

public final class ClienteRepository {

    private ClienteDataService service;

    public ClienteRepository() {
        this.service = APIClient.getInstance().create(ClienteDataService.class);
    }

    public Call<ClienteSaveResponse> save(Cliente cliente) {
        return service.save(cliente);
    }

    public Call<ClienteLoginResponse> login(ClienteLoginRequest loginRequest) {
        return service.login(loginRequest);
    }

    public Call<ClienteValidarCartaoResponse> validarCartao(ClienteValidarCartaoRequest validarCartaoRequest) {
        return service.validarCartao(validarCartaoRequest);
    }

    public Call<ClientePassagensResponse> passagens(Cliente cliente) {
        return service.passagens(cliente.getId());
    }

}
