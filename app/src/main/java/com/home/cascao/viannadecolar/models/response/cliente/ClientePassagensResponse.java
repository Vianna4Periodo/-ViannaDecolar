package com.home.cascao.viannadecolar.models.response.cliente;

import com.google.gson.annotations.SerializedName;
import com.home.cascao.viannadecolar.models.Passagem;

import java.util.List;

public class ClientePassagensResponse {

    @SerializedName("passagens")
    private List<Passagem> passagens;

    public ClientePassagensResponse() { }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
}
