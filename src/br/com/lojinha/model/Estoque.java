package br.com.lojinha.model;

public class Estoque {
    private int idEstoque;
    private String local;

    public Estoque(int idEstoque, String local) {
        this.idEstoque = idEstoque;
        this.local = local;
    }

    // Getters and Setters
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
}
