package models;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Entidade {

    private List<Livro> listaLivro;


    public Autor(String nome) {
        super(nome);
        listaLivro = new ArrayList<>();
    }

    public void addLivro(Livro livro){
        listaLivro.add(livro);
    }

    public List<Livro> getListaLivro() {
        return listaLivro;
    }
}
