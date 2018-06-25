package com.home.cascao.viannadecolar.models;

import com.google.gson.annotations.SerializedName;

public class Passagem {

    @SerializedName("createdAt")
    private int createdAt;

    @SerializedName("updatedAt")
    private int updatedAt;

    @SerializedName("id")
    private int id;

    public Passagem() { }

    public int getCreatedAt() {
        return createdAt;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }

}
