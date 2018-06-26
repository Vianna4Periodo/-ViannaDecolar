package com.home.cascao.viannadecolar.models;

import com.google.gson.annotations.SerializedName;

public class Voo {

    @SerializedName("createdAt")
    private long createdAt;

    @SerializedName("updatedAt")
    private long updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("dataSaida")
    private String dataSaida;

    @SerializedName("dataChegada")
    private String dataChegada;

    @SerializedName("destino")
    private String destino;

    @SerializedName("origem")
    private String origem;

    @SerializedName("valor")
    private double valor;

    @SerializedName("capacidadeMaxima")
    private int capacidadeMaxima;

//    @SerializedName("aeronave")
//    private Aeronave aeronave;

    public Voo() { }

    public Voo(long createdAt, long updatedAt, String dataSaida, String dataChegada, String destino, String origem, double valor, int capacidadeMaxima) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
        this.destino = destino;
        this.origem = origem;
        this.valor = valor;
        this.capacidadeMaxima = capacidadeMaxima;
//        this.aeronave = aeronave;
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

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

//    public Aeronave getAeronave() {
//        return aeronave;
//    }
//
//    public void setAeronave(Aeronave aeronave) {
//        this.aeronave = aeronave;
//    }

}
