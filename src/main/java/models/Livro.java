package models;

import java.util.List;

public class Livro {
    private String titulo;
    private List<Autor> listaAutores;
    private int quantidade;

    private List<Genero> listaGeneros;

    private List<SubGenero> listaSubGenero;

    private Editora editora;

    private int edicao;

    private int ISBN;
    private int ano;
    private String prateleira;
    private String estante;
    private String sala;
    private String sinopse;

    public Livro(String titulo, List<Autor> listaAutores, int quantidade, List<Genero> listaGeneros, List<SubGenero> listaSubGenero, Editora editora,int ano, int edicao, int ISBN, String prateleira, String estante, String sala, String sinopse) {
        this.titulo = titulo;
        this.listaAutores = listaAutores;
        this.quantidade = quantidade;
        this.listaGeneros = listaGeneros;
        this.listaSubGenero = listaSubGenero;
        this.ano = ano;
        this.editora = editora;
        this.edicao = edicao;
        this.ISBN = ISBN;
        this.prateleira = prateleira;
        this.estante = estante;
        this.sala = sala;
        this.sinopse = sinopse;
    }


    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public List<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public List<SubGenero> getListaSubGenero() {
        return listaSubGenero;
    }

    public Editora getEditora() {
        return editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public String getEstante() {
        return estante;
    }

    public String getSala() {
        return sala;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getAno() {return ano;}


    // Método para incrementar a quantidade disponível do livro
    public void incrementarQuantidadeDisponivel() {
        this.quantidade++;
    }
}
