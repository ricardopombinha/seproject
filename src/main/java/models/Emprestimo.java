package models;

public class Emprestimo {

    private int diasDeEmprestimo;

    private String nomeSocio;
    private int numeroSocio;

    public Emprestimo(int diasDeEmprestimo, String nomeSocio, int numeroSocio) {
        this.diasDeEmprestimo = diasDeEmprestimo;
        this.nomeSocio = nomeSocio;
        this.numeroSocio = numeroSocio;

    }

    public int getDiasDeEmprestimo() {
        return diasDeEmprestimo;
    }

    public String getNomeSocio() {
        return nomeSocio;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }
}
