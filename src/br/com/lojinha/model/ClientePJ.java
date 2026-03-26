package br.com.lojinha.model;

public class ClientePJ extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public ClientePJ(int idCliente, String nome, String endereco, String cnpj, String razaoSocial) {
        super(idCliente, nome, endereco, "PJ");
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    // Getters e Setters
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
}
