package com.home.cascao.viannadecolar;

import com.home.cascao.viannadecolar.models.Cliente;

public final class Utils {

    private static Cliente cliente;

    public static Utils getInstance() {
        return new Utils();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
