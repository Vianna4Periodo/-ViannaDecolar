package com.home.cascao.viannadecolar.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        Session session = new DefaultSession();
//        Session session = new LocalSession();
        return APIClient.getRetrofitInstance(session);
    }

    public static Retrofit getRetrofitInstance(Session session) {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(session.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}