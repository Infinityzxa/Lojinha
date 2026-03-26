package br.com.lojinha.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private String statusPedido;
    private String descricao;
    private Cliente cliente;
    private double frete;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(int idPedido, Cliente cliente, double frete, String descricao) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.frete = frete;
        this.descricao = descricao;
        this.statusPedido = "Criado";
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double totalItens = 0;
        for (ItemPedido item : itens) {
            totalItens += item.getSubTotal();
        }
        return totalItens + frete;
    }

    // Getters e Setters
    public int getIdPedido() { return idPedido; }
    public String getStatusPedido() { return statusPedido; }
    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }
    public String getDescricao() { return descricao; }
    public Cliente getCliente() { return cliente; }
    public double getFrete() { return frete; }
    public List<ItemPedido> getItens() { return itens; }
    public Pagamento getPagamento() { return pagamento; }
    public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }
}
