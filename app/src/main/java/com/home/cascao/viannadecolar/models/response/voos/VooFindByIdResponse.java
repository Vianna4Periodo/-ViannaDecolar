package com.home.cascao.viannadecolar.models.response.voos;

import com.google.gson.annotations.SerializedName;
import com.home.cascao.viannadecolar.models.Voo;

public class VooFindByIdResponse {

    @SerializedName("voo")
    private Voo voo;

    public VooFindByIdResponse(Voo voo) {
        this.voo = voo;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

}
