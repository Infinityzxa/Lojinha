package br.com.lojinha.model;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String razaoSocial;
    private String cnpj;

    public Fornecedor(int idFornecedor, String nome, String razaoSocial, String cnpj) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    // Getters and Setters
    public int getIdFornecedor() { return idFornecedor; }
    public void setIdFornecedor(int idFornecedor) { this.idFornecedor = idFornecedor; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
