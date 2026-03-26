package br.com.lojinha.model;

public class ClientePF extends Cliente {
    private String cpf;
    private String dataNascimento;

    public ClientePF(int idCliente, String nome, String endereco, String cpf, String dataNascimento) {
        super(idCliente, nome, endereco, "PF");
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
}
