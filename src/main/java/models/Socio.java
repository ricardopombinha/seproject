package models;

import java.util.ArrayList;
import java.util.List;

public class Socio extends EntidadeComMoradaEmailTel {

    private int nif;
    private Date dataNascimento;
    private char genero;
    private int numeroSocio;
    private int multa;
    private Date dataAnuidade;
    private List<Autor> listaAutores;
    private List<LivroInstancia> listaLivrosRequisitadosAtualmente;
    private List<Requisicao> listaRequisicoes;
    private List<Reserva> listaDeEspera;

    private List<SubGenero> selecionados; // Lista para armazenar os gêneros selecionados

    //lista de generos como a list em cimas


    public Socio(String nome, String morada, int telefone, String email, int nif, Date dataNascimento, char genero, Date dataAnuidade, int numeroSocio) {
        super(nome, morada, telefone, email);
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.multa = 0;
        this.dataAnuidade = dataAnuidade;
        listaAutores = new ArrayList<>();
        listaLivrosRequisitadosAtualmente = new ArrayList<>();
        listaRequisicoes = new ArrayList<>();
        this.numeroSocio = numeroSocio;
        listaDeEspera = new ArrayList<>();
    }

    public Socio(String nome, String morada, int telefone, String email, int nif, Date dataNascimento, char genero, Date dataAnuidade, int numeroSocio, List<SubGenero> selecionados, List<Autor> autores) {
        super(nome, morada, telefone, email);
        this.nif = nif;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.multa = 0;
        this.dataAnuidade = dataAnuidade;
        this.listaAutores = autores;
        listaLivrosRequisitadosAtualmente = new ArrayList<>();
        listaRequisicoes = new ArrayList<>();
        this.numeroSocio = numeroSocio;
        listaDeEspera = new ArrayList<>();
        this.selecionados = selecionados;
    }

    public List<Reserva> getListaDeEspera() {
        return listaDeEspera;
    }

    public int getNif() {
        return nif;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public char getGenero() {
        return genero;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public int getMulta() {
        return multa;
    }

    public Date getDataAnuidade() {
        return dataAnuidade;
    }

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public List<LivroInstancia> getlistaLivrosRequisitadosAtualmente() {
        return listaLivrosRequisitadosAtualmente;
    }

    public List<Requisicao> getListaRequisicoes() {
        return listaRequisicoes;
    }

    public int getRequisicaoAtivasNumero(){
        return listaLivrosRequisitadosAtualmente.size();
    }

    public void addRequisicaoHistorico(Requisicao requisicao){
        listaRequisicoes.add(requisicao);
    }

    public void addLivroRequisitadoAtualmente(LivroInstancia livroInstancia){
        listaLivrosRequisitadosAtualmente.add(livroInstancia);
    }

    public void removeLivroRequisitadoAtualmente(LivroInstancia livroInstancia){
        for(int i = 0; i <listaLivrosRequisitadosAtualmente.size(); i++){
            if(listaLivrosRequisitadosAtualmente.get(i).getCodigoLivro() == livroInstancia.getCodigoLivro()){
                listaLivrosRequisitadosAtualmente.remove(i);
            }
        }

        /*OU
        listaLivrosRequisitadosAtualmente.remove(livroInstancia);
         */
    }

    public void addListaDeEspera(Reserva reserva){
        listaDeEspera.add(reserva);
    }

    public void removeListaDeEspera(Reserva reserva){

        listaDeEspera.remove(reserva);

    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public void pagar() {
        this.multa = 0;
    }

    public void setDataAnuidade(int novoDiaAnuidade, int novoMesAnuidade, int novoAnoAnuidade) {
        Date novaAnuidade = new Date(novoDiaAnuidade, novoMesAnuidade, novoAnoAnuidade);
        this.dataAnuidade = novaAnuidade;
    }

    public List<SubGenero> getListaGeneros() {
        return selecionados;
    }
}
