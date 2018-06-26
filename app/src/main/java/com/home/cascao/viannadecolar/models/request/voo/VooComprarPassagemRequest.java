package com.home.cascao.viannadecolar.models.request.voo;

public class VooComprarPassagemRequest {

    private int idVoo;
    private int idCliente;
    private int quantidade;
    private int pagamento;

    public VooComprarPassagemRequest(int idVoo, int idCliente, int quantidade, int pagamento) {
        this.idVoo = idVoo;
        this.idCliente = idCliente;
        this.quantidade = quantidade;
        this.pagamento = pagamento;
    }

    public int getIdVoo() {
        return idVoo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getPagamento() {
        return pagamento;
    }

}