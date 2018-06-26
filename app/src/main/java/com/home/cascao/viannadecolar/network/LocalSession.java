package com.home.cascao.viannadecolar.network;

public class LocalSession implements Session {
    @Override
    public String getBaseUrl() {
        return "http://127.0.0.1:1337/api/v1/";
    }
}
