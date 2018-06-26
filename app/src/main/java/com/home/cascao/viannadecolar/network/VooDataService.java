package com.home.cascao.viannadecolar.network;

import com.home.cascao.viannadecolar.models.Voo;
import com.home.cascao.viannadecolar.models.request.voo.VooCancelarPassagemRequest;
import com.home.cascao.viannadecolar.models.request.voo.VooComprarPassagemRequest;
import com.home.cascao.viannadecolar.models.request.voo.VooSearchRequest;
import com.home.cascao.viannadecolar.models.response.voos.VooComprarPassagemResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooFindByIdResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooFindResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VooDataService {

    @GET("voos")
    Call<VooFindResponse> find();

    @GET("voos/{id}")
    Call<VooFindByIdResponse> findById(@Path("id") int id);

    @POST("voos/comprar-passagem")
    Call<VooComprarPassagemResponse> comprarPassagem(@Body VooComprarPassagemRequest comprarPassagemRequest);

    @POST("voos/cancelar-passagem")
    Call<Void> cancelarPassagem(@Body VooCancelarPassagemRequest cancelarPassagemRequest);

    @POST("voos/pesquisar")
    Call<VooSearchResponse> search(@Body VooSearchRequest vooSearchRequest);

}