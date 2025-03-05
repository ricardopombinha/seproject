package models;

public class Requisicao extends Emprestimo {
    private boolean requisicaoAtiva;

    private Date dataEmprestimo;

    private LivroInstancia livroInstancia;


    public Requisicao(int diasDeEmprestimo, String nomeSocio, int numeroSocio, Date dataEmprestimo, LivroInstancia livro) {
        super(diasDeEmprestimo, nomeSocio, numeroSocio);
        this.requisicaoAtiva = true;
        this.dataEmprestimo = dataEmprestimo;
        this.livroInstancia = livro;
    }

    public boolean isRequisicaoAtiva() {
        return requisicaoAtiva;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LivroInstancia getLivroInstancia() {
        return livroInstancia;
    }

    public void setRequisicaoAtiva(boolean requisicaoAtiva) {
        this.requisicaoAtiva = requisicaoAtiva;
    }

}
