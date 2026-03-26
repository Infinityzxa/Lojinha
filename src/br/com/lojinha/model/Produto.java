package br.com.lojinha.model;

public class Produto {
    private int idProduto;
    private String categoria;
    private String descricao;
    private double valor;

    public Produto(int idProduto, String categoria, String descricao, double valor) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
