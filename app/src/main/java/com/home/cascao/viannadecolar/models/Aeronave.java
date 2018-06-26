package com.home.cascao.viannadecolar.models;

import com.google.gson.annotations.SerializedName;

public class Aeronave {

    @SerializedName("createdAt")
    private long createdAt;

    @SerializedName("updatedAt")
    private long updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    public Aeronave() { }

    public Aeronave(long createdAt, long updatedAt, String nome) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
