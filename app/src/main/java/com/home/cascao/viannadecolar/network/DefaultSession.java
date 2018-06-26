package com.home.cascao.viannadecolar.network;

public final class DefaultSession implements Session {

    @Override
    public String getBaseUrl() {
        return "https://aeroporto-api.herokuapp.com/api/v1/";
    }

}
