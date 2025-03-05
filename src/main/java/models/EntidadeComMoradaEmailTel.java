package models;

public class EntidadeComMoradaEmailTel extends Entidade{

    private String morada;
    private int telefone;
    private String email;

    public EntidadeComMoradaEmailTel(String nome, String morada, int telefone, String email) {
        super(nome);
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
