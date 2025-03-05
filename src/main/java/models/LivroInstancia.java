package models;

import java.util.List;

public class LivroInstancia extends Livro {

    private int codigoLivro;
    private boolean requisitado;


    public LivroInstancia(String titulo, List<Autor> listaAutores, int quantidade, List<Genero> listaGeneros, List<SubGenero> listaSubGenero, Editora editora,int ano, int edicao, int ISBN, String prateleira, String estante, String sala, String sinopse, int codigoLivro) {
        super(titulo, listaAutores, quantidade, listaGeneros, listaSubGenero, editora,ano, edicao, ISBN, prateleira, estante, sala, sinopse);
        this.codigoLivro = codigoLivro;
        requisitado = false;

    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public boolean isRequisitado(){
        return requisitado;
    }

    public void setRequisitado(boolean requisitado) {
        this.requisitado = requisitado;
    }
}
