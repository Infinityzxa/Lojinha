package br.com.lojinha.model;

import java.time.LocalDate;

public class Entrega {
    private String codRastreio;
    private String status;
    private LocalDate dataEntrega;

    public Entrega(String codRastreio, String status) {
        this.codRastreio = codRastreio;
        this.status = status;
    }

    // Getters and Setters
    public String getCodRastreio() { return codRastreio; }
    public void setCodRastreio(String codRastreio) { this.codRastreio = codRastreio; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }
}
