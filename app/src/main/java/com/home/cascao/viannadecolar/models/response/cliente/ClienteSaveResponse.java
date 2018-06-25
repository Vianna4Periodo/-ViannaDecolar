package com.home.cascao.viannadecolar.models.response.cliente;

import com.google.gson.annotations.SerializedName;
import com.home.cascao.viannadecolar.models.Cliente;

public class ClienteSaveResponse {

    @SerializedName("cliente")
    private Cliente cliente;

    public ClienteSaveResponse() { }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
