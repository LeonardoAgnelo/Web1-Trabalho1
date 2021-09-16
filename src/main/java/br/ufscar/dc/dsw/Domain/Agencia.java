package br.ufscar.dc.dsw.Domain;

public class Agencia extends Usuario {
    private String cnpj;
    private String descricao;

    public Agencia(Integer id, String nome, String email, String senha, String tipo, String cnpj, String descricao) {
        super(id, nome, email, senha, tipo);

        this.setCpf(cnpj);
        this.setTelefone(descricao);
    }

    public Agencia(String nome, String email, String senha, String tipo, String cnpj, String descricao) {
        super(nome, email, senha, tipo);

        this.setCpf(cnpj);
        this.setTelefone(descricao);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
