package com.home.cascao.viannadecolar.models;

import com.google.gson.annotations.SerializedName;

public class Passagem {

    @SerializedName("createdAt")
    private long createdAt;

    @SerializedName("updatedAt")
    private long updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("voo")
    private Voo voo;

    public Passagem() { }

    public Passagem(long createdAt, long updatedAt, Voo voo) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.voo = voo;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
}
