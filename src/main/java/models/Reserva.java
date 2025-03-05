package models;

public class Reserva extends Emprestimo {
    private Livro livro;
    public Reserva(int diasDeEmprestimo, String nomeSocio, int numeroSocio, Livro livro) {
        super(diasDeEmprestimo, nomeSocio, numeroSocio);
        this.livro = livro;
    }

    public Livro getLivro() {
        return livro;
    }
}
