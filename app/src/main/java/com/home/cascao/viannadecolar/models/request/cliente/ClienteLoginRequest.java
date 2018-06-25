package com.home.cascao.viannadecolar.models.request.cliente;

public class ClienteLoginRequest {

    private String email;
    private String password;

    public ClienteLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
