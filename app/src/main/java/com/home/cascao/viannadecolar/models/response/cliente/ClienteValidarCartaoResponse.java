package com.home.cascao.viannadecolar.models.response.cliente;

import com.google.gson.annotations.SerializedName;

public class ClienteValidarCartaoResponse {

    @SerializedName("isValid")
    private Boolean isValid;

    public ClienteValidarCartaoResponse(Boolean isValid) {
        this.isValid = isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getValid() {
        return isValid;
    }

}
