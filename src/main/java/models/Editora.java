package models;

import java.util.ArrayList;
import java.util.List;

public class Editora extends EntidadeComMoradaEmailTel {


    private List<Livro> listaLivro;

    public Editora(String nome, String morada, int telefone, String email) {
        super(nome, morada, telefone, email);

        listaLivro = new ArrayList<>();
    }

    public void addLivro(Livro livro){
        listaLivro.add(livro);
    }

    public List<Livro> getListaLivro() {
        return listaLivro;
    }
}
