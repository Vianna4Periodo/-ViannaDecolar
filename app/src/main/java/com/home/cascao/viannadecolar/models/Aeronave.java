package com.home.cascao.viannadecolar.models;

import com.google.gson.annotations.SerializedName;

public class Aeronave {

    @SerializedName("createdAt")
    private int createdAt;

    @SerializedName("updatedAt")
    private int updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    public Aeronave() { }

    public Aeronave(String nome) {
        this.nome = nome;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public int getUpdatedAt() {
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
