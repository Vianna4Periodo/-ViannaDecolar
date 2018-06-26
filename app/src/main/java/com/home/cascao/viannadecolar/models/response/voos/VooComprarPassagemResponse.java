package com.home.cascao.viannadecolar.models.response.voos;

import com.google.gson.annotations.SerializedName;
import com.home.cascao.viannadecolar.models.Passagem;

import java.util.List;

public class VooComprarPassagemResponse {

    @SerializedName("passagens")
    private List<Passagem> passagens;

    public VooComprarPassagemResponse() { }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
}
