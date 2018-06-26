package com.home.cascao.viannadecolar.network;

import com.home.cascao.viannadecolar.models.Cliente;
import com.home.cascao.viannadecolar.models.request.cliente.ClienteLoginRequest;
import com.home.cascao.viannadecolar.models.request.cliente.ClienteValidarCartaoRequest;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteLoginResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClientePassagensResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteSaveResponse;
import com.home.cascao.viannadecolar.models.response.cliente.ClienteValidarCartaoResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ClienteDataService {

    @POST("clientes")
    Call<ClienteSaveResponse> save(@Body Cliente cliente);

    @POST("clientes/validar-cartao")
    Call<ClienteValidarCartaoResponse> validarCartao(@Body ClienteValidarCartaoRequest validarCartaoRequest);

    @POST("clientes/login")
    Call<ClienteLoginResponse> login(@Body ClienteLoginRequest loginRequest);

    @GET("clientes/passagens/{id}")
    Call<ClientePassagensResponse> passagens(@Path("id") int idCliente);

}
