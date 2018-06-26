package com.home.cascao.viannadecolar.repository;

import com.home.cascao.viannadecolar.models.request.voo.VooCancelarPassagemRequest;
import com.home.cascao.viannadecolar.models.request.voo.VooComprarPassagemRequest;
import com.home.cascao.viannadecolar.models.request.voo.VooSearchRequest;
import com.home.cascao.viannadecolar.models.response.voos.VooComprarPassagemResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooFindByIdResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooFindResponse;
import com.home.cascao.viannadecolar.models.response.voos.VooSearchResponse;
import com.home.cascao.viannadecolar.network.APIClient;
import com.home.cascao.viannadecolar.network.VooDataService;

import retrofit2.Call;

public final class VooRepository {

    private VooDataService service;

    public VooRepository() {
        this.service = APIClient.getInstance().create(VooDataService.class);
    }

    public Call<VooFindResponse> find() {
        return service.find();
    }

    public Call<VooFindByIdResponse> findById(int id) {
        return service.findById(id);
    }

    public Call<VooComprarPassagemResponse> comprarPassagem(VooComprarPassagemRequest comprarPassagemRequest) {
        return service.comprarPassagem(comprarPassagemRequest);
    }

    public Call<Void> cancelarPassagem(VooCancelarPassagemRequest cancelarPassagemRequest) {
        return service.cancelarPassagem(cancelarPassagemRequest);
    }

    public Call<VooSearchResponse> search(VooSearchRequest searchRequest) {
        return service.search(searchRequest);
    }

}
