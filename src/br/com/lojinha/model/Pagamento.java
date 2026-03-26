package br.com.lojinha.model;

import java.time.LocalDate;

public class Pagamento {
    private int idPagamento;
    private LocalDate dataPagamento;
    private String tipoPagamento;

    public Pagamento(int idPagamento, LocalDate dataPagamento, String tipoPagamento) {
        this.idPagamento = idPagamento;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    // Getters e Setters
    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }
    public String getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(String tipoPagamento) { this.tipoPagamento = tipoPagamento; }
}
