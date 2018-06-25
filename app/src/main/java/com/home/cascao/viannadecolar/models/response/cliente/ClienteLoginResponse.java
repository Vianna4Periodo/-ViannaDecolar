package com.home.cascao.viannadecolar.models.response.cliente;

import com.google.gson.annotations.SerializedName;
import com.home.cascao.viannadecolar.models.Cliente;

public class ClienteLoginResponse {

    @SerializedName("cliente")
    private Cliente cliente;

    public ClienteLoginResponse() { }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
