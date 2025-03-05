import models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class Repositorio {

    private static Repositorio instance;
    private List<Socio> socios;
    private List<Requisicao> requisicoes;
    private List<Reserva> reservas;
    private List<Livro> livros;
    private List<Editora> editoras;
    private List<Autor> autores;
    private List<LivroInstancia> livrosExemplares;
    private int numeroSocios;
    private Repositorio(){

        //socios
        socios = new ArrayList<>();
        Socio socio1 = new Socio("Antonio", "Rua da Avenida",911231233, "a1@mail.pt", 123456789,new Date(17,9,1998),'M',new Date(23,2,2020),1);
        Socio socio2 = new Socio("Ricardo", "Rua da Liberdade",918730542, "r92@mail.pt", 593754097,new Date(14,4,2004),'F',new Date(23,9,2022),2);
        Socio socio3 = new Socio("Rodrigo", "Rua Principal",921222933, "tostas@mail.pt", 602748923,new Date(23,7,2004),'O',new Date(13,11,2019),3);
        Socio socio4 = new Socio("Duarte", "Rua Mós",962936785, "red@mail.pt", 957864676,new Date(12,2,1994),'F',new Date(30,1,2016),4);
        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);
        socios.add(socio4);

        numeroSocios = 4;

        //editoras
        //Editora(String nome, String morada, int telefone, String email)
        editoras = new ArrayList<>();
        Editora editora1 =new Editora("Porto Editora", "Rua Lisboa", 942378522, "portoeditora@mail.pt");
        Editora editora2 =new Editora("Devir", "Rua Leiria", 976593675, "devir@mail.pt");
        Editora editora3 =new Editora("Leya", "Rua Porto", 939876545, "Leya@mail.pt");
        editoras.add(editora1);
        editoras.add(editora2);
        editoras.add(editora3);

        //Autores
        //ublic Autor(String nome)
        autores = new ArrayList<>();
        Autor autor1 =new Autor("Eichiro Oda");
        Autor autor2 =new Autor("Andrzej Sapkowski");
        Autor autor3 =new Autor("J. K. Rowling");
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);


        List<Autor> listaAux = new ArrayList<>();
        listaAux.add(autor1);
        List<Genero> listaAuxGenero = new ArrayList<>();
        listaAuxGenero.add(Genero.Narrativo);
        List<SubGenero> listaAuxSubGenero = new ArrayList<>();
        listaAuxSubGenero.add(SubGenero.Fantasia);
        listaAuxSubGenero.add(SubGenero.GraphicNovel);

        List<SubGenero> listaAuxSubGenero2 = new ArrayList<>();
        listaAuxSubGenero2.add(SubGenero.Fantasia);
        List<Autor> listaAux2 = new ArrayList<>();
        listaAux2.add(autor2);
        //instancias
        //    public LivroInstancia(String titulo, List<Autor> listaAutores, int quantidade, List<Genero> listaGeneros, List<SubGenero> listaSubGenero, Editora editora, int edicao, int ISBN, String prateleira, String estante, String sala, String sinopse) {
        livrosExemplares = new ArrayList<>();
        LivroInstancia livroInstancia1 = new LivroInstancia("One Piece Vol.1", listaAux,3, listaAuxGenero,

                listaAuxSubGenero,editora2,1997,1,1234,"52A","F","R12","o luffy vai ser o rei dos piratas",1);
        LivroInstancia livroInstancia2 = new LivroInstancia("One Piece Vol.1", listaAux,3, listaAuxGenero,
                listaAuxSubGenero,editora2,1997,1,1234,"52A","F","R12","o luffy vai ser o rei dos piratas",2);
        LivroInstancia livroInstancia3 = new LivroInstancia("One Piece Vol.1", listaAux,3, listaAuxGenero,
                listaAuxSubGenero,editora2,1997,1,1234,"52A","F","R12","o luffy vai ser o rei dos piratas",3);
        LivroInstancia livroInstancia4 = new LivroInstancia("Batismo de Fogo", listaAux2,2, listaAuxGenero,
                listaAuxSubGenero2,editora3,2001,2,74792,"13B","A","R42","Geralt nas aventuras",4);
        LivroInstancia livroInstancia5 = new LivroInstancia("Batismo de Fogo", listaAux2,2, listaAuxGenero,
                listaAuxSubGenero2,editora3,2001,2,74792,"13B","A","R42","Geralt nas aventuras",5);

        livroInstancia2.setRequisitado(true);
        livrosExemplares.add(livroInstancia1);
        livrosExemplares.add(livroInstancia2);
        livrosExemplares.add(livroInstancia3);
        livrosExemplares.add(livroInstancia4);
        livrosExemplares.add(livroInstancia5);


        livros = new ArrayList<>();
        Livro livro1 = new Livro("One Piece Vol.1", listaAux,3, listaAuxGenero,

                listaAuxSubGenero,editora2,1997,1,1234,"52A","F","R12","o luffy vai ser o rei dos piratas");
        Livro livro2 = new Livro("Batismo de Fogo", listaAux2,2, listaAuxGenero,
                listaAuxSubGenero2,editora3,2001,2,74792,"13B","A","R42","Geralt nas aventuras");


        livros.add(livro1);
        livros.add(livro2);

        editora2.addLivro(livro1);
        editora3.addLivro(livro2);
        autor1.addLivro(livro1);
        autor2.addLivro(livro2);

        reservas = new ArrayList<>();
        requisicoes = new ArrayList<>();


        //socio1.setMulta(100);
        socio3.setMulta(2200);

    }

    public static Repositorio getInstance(){
        if(instance == null){
            instance = new Repositorio();
        }
        return instance;
    }

    public static void setInstanceNull(){
        instance = null;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Editora> getEditoras() {
        return editoras;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<LivroInstancia> getLivrosExemplares() {
        return livrosExemplares;
    }

    public int confimarEGuardarRequisicao(String nomeLivro,String nomeAutor, String nomeSocio, String numeroSocio, String tempo, String codigoLivro){
        int numSocio;
        try{
            numSocio = Integer.valueOf(numeroSocio);

        }catch (NumberFormatException e ){
            return 12;
        }

        int tempoDias;
        try{
            tempoDias = Integer.valueOf(tempo);

        }catch (NumberFormatException e ){
            return 13;
        }
        int codigoLivroInt;
        try{
            codigoLivroInt = Integer.valueOf(codigoLivro);

        }catch (NumberFormatException e ){
            return 14;
        }

        int flag;
        flag = validarNomeLivro(nomeLivro);
        if( flag != 0){
            return flag;
        }

        flag = validarAutorLivro(nomeAutor, nomeLivro);
        if(flag != 0){
            return flag;
        }
        flag = validarSocio(nomeSocio,numSocio);
        if(flag != 0){
            return flag;
        }

        flag = validarTempo(tempoDias);
        if(flag != 0){
            return flag;
        }
        flag = validarCodigoLivro(codigoLivroInt, nomeLivro);

        if(flag != 0){
            return flag;
        }

        return guardarDadosRequisicao(nomeLivro, nomeAutor, nomeSocio, numSocio,tempoDias,codigoLivroInt);
    }
    public int confimarEGuardarReserva(String nomeLivro,String nomeAutor, String nomeSocio, String numeroSocio, String tempo){

        int numSocio;
        try{
            numSocio = Integer.valueOf(numeroSocio);

        }catch (NumberFormatException e ){
            return 12;
        }

        int tempoDias;
        try{
            tempoDias = Integer.valueOf(tempo);

        }catch (NumberFormatException e ){
            return 13;
        }

        int flag;
        flag = validarNomeLivro(nomeLivro);
        if( flag != 0){
            return flag;
        }

        flag = validarAutorLivro(nomeAutor, nomeLivro);
        if(flag != 0){
            return flag;
        }
        flag = validarSocio(nomeSocio,numSocio);
        if(flag != 0){
            return flag;
        }

        flag = validarTempo(tempoDias);
        if(flag != 0){
            return flag;
        }
        //se houver livros disponiveis nao pode requisitar
        flag = validarLivroDisponivel(nomeLivro);
        if( flag != 0){
            return flag;
        }


        return guardarDadosReserva(nomeLivro, nomeAutor, nomeSocio, numSocio,tempoDias);
    }

    private int validarLivroDisponivel(String nomeLivro) {

        for(int i = 0; i< livrosExemplares.size(); i++){
            LivroInstancia livroAux = livrosExemplares.get(i);
            if(livroAux.getTitulo().compareTo(nomeLivro) == 0 && !livroAux.isRequisitado()){
                return 15;
            }
        }

        return 0;
    }

    private int guardarDadosRequisicao(String nomeLivro, String nomeAutor, String nomeSocio, int numeroSocio, int tempo, int codigoLivro) {
        LivroInstancia livroInstancia = null;
        Socio socio = null;


        for(int i = 0; i< livrosExemplares.size(); i++){
            livroInstancia = livrosExemplares.get(i);
            if(livroInstancia.getCodigoLivro() == codigoLivro){
                break;
            }
        }

        for(int i = 0; i<socios.size();i++){
            socio = socios.get(i);
            if(socio.getNumeroSocio() == numeroSocio){
                break;
            }
        }

        LocalDate hoje = LocalDate.now();

        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        Date dataAtual = new Date(dia, mes, ano);
        livroInstancia.setRequisitado(true);
        //requisição e meter data atual
        Requisicao requisicaoNova = new Requisicao(tempo, nomeSocio,numeroSocio,  dataAtual, livroInstancia);

        livroInstancia.setRequisitado(true);

        //no socio meter a requisiçao na lista de requisição e a lista de livros requisitados
        socio.addLivroRequisitadoAtualmente(livroInstancia);
        socio.addRequisicaoHistorico(requisicaoNova);
        requisicoes.add(requisicaoNova);

        return 0;
    }

    private int guardarDadosReserva(String nomeLivro, String nomeAutor, String nomeSocio, int numeroSocio, int tempo) {
        Livro livro = null;
        Socio socio = null;


        for(int i = 0; i< livros.size(); i++){
            livro = livros.get(i);
            if(livro.getTitulo().compareTo(nomeLivro) == 0){
                break;
            }
        }

        for(int i = 0; i<socios.size();i++){
            socio = socios.get(i);
            if(socio.getNumeroSocio() == numeroSocio){
                break;
            }
        }

        //requisição e meter data atual
        Reserva reservaNova = new Reserva(tempo,nomeSocio,numeroSocio,livro);

        socio.addListaDeEspera(reservaNova);
        Repositorio.getInstance().reservas.add(reservaNova);


        return 0;
    }

    private int validarNomeLivro(String nomeLivro){
        for(int i = 0; i< livros.size(); i++){
            Livro livroAux = livros.get(i);
            if(livroAux.getTitulo().compareTo(nomeLivro) == 0){
                return 0;
            }
        }
        return 1;
    }
    private int validarAutorLivro(String nomeAutor, String nomeLivro){

        boolean autorExiste = false;
        for(int i = 0; i< autores.size(); i++){
            Autor autorAux = autores.get(i);
            if(autorAux.getNome().compareTo(nomeAutor) == 0){
                autorExiste = true;
                break;

            }
        }

        if(!autorExiste){
            return 2;
        }

        List<Autor> listaAutorAux = new ArrayList<>();
        for(int i = 0; i< livros.size(); i++){
            Livro livroAux = livros.get(i);
            if(livroAux.getTitulo().compareTo(nomeLivro) == 0){
                listaAutorAux = livroAux.getListaAutores();
            }
        }

        for(int i = 0; i < listaAutorAux.size(); i++){
            Autor autor = listaAutorAux.get(i);
            if(autor.getNome().compareTo(nomeAutor) == 0){
                return 0;
            }
        }
        return 3;
    }
    private int validarSocio(String nomeSocio, int numeroSocio){


        for(int i = 0; i< socios.size(); i++){
            Socio socio = socios.get(i);
            if(socio.getNumeroSocio() == numeroSocio){
                if(socio.getNome().compareTo(nomeSocio) != 0){
                    return 11;
                }

                if(socio.getRequisicaoAtivasNumero() >=4){
                    return 8;
                }
                if(socio.getMulta() > 0){
                    return 9;
                }

                return 0;
            }
        }


        return 10;

    }
    private int validarTempo(int tempo){

        if(tempo >= 1 && tempo <= 15){
            return 0;
        }
        return 4;
    }
    private int validarCodigoLivro(int codigoLivro, String nomeLivro){

        for(int i = 0; i< livrosExemplares.size(); i++){
            LivroInstancia livroAux = livrosExemplares.get(i);
            if(livroAux.getCodigoLivro() == codigoLivro && livroAux.getTitulo().compareTo(nomeLivro) == 0){
                if(livroAux.isRequisitado()){
                    return 7;
                }
                return 0;
            }
        }

        return 6;
    }

    public List<Livro> pesquisarLivros(String titulo, List<Genero> generos, List<SubGenero> subGeneros) {
        List<Livro> resultados = new ArrayList<>();

        for (Livro livro : livros) {
            boolean matchesTitle = titulo == null || titulo.isEmpty() || livro.getTitulo().toLowerCase().contains(titulo.toLowerCase());
            boolean matchesGenero = generos.isEmpty() || generos.stream().anyMatch(g -> livro.getListaGeneros().contains(g));
            boolean matchesSubGenero = subGeneros.isEmpty() || subGeneros.stream().anyMatch(sg -> livro.getListaSubGenero().contains(sg));

            if (matchesTitle && matchesGenero && matchesSubGenero) {
                resultados.add(livro);
            }
        }

        return resultados;
    }

    public List<Socio> getSociosComLivroRequisitado(Livro livro) {
        List<Socio> sociosComLivro = new ArrayList<>();

        for (Socio socio : socios){
            for (LivroInstancia livroInstancia : socio.getlistaLivrosRequisitadosAtualmente()){
                if(livroInstancia.getISBN() == livro.getISBN()){
                    sociosComLivro.add(socio);
                }
            }
        }

        return sociosComLivro;
    }

    public void devolverLivro(Socio socio, LivroInstancia livro) {


        /*List<LivroInstancia> livrosAtuais = socio.getlistaLivrosRequisitadosAtualmente();

        LivroInstancia instanciaDoLivro = null;

        for(LivroInstancia livroInstancia : livrosAtuais){
            if(livroInstancia.getCodigoLivro() == livro.getCodigoLivro()){
                instanciaDoLivro = livroInstancia;
                break;
            }
        }

        socio.removeLivroRequisitadoAtualmente(instanciaDoLivro);
        instanciaDoLivro.setRequisitado(false);*/

        socio.removeLivroRequisitadoAtualmente(livro);
        livro.setRequisitado(false);


    }


    public int confimarEGuardarAutor(String nomeAutor) {
        int flag;

        flag = verificaNomeAutor(nomeAutor);
        if( flag != 0){
            return flag;
        }

        return guardarDadosAutor(nomeAutor);
    }

    private int guardarDadosAutor(String nomeAutor) {
        Autor autorNovo = new Autor(nomeAutor);
        autores.add(autorNovo);
        return 0;
    }

    private int verificaNomeAutor(String nomeAutor){
        //Regex se nao existe caractres especiais e pontuação mas deixa passar o ponto final para abreviações

        if(validarNomeCarecteresEspeciais(nomeAutor) != 0){
            return 1;
        }

        for (int i = 0; i < autores.size(); i++) {
            Autor autorAux = autores.get(i);
            if(autorAux.getNome().compareTo(nomeAutor) == 0){
                return 2;
            }

        }

        return 0;
    }

    public int confimarEGuardarEditora(String editoraNome, String morada, String telefone, String email) {
        int flag = 0;

        flag = validarNomeEditora(editoraNome);
        if( flag != 0){
            return flag;
        }

        flag = validarMorada(morada);
        if( flag != 0){
            return flag;
        }


        flag = validarTelefone(telefone);
        if( flag != 0){
            return flag;
        }

        flag = validarEmail(email);
        if( flag != 0){
            return flag;
        }



        return guardarDadosEditora(editoraNome, morada, telefone, email);

    }

    private int guardarDadosEditora(String editoraNome, String morada, String telefone, String email) {

        Editora editoraNova = new Editora(editoraNome,morada,Integer.valueOf(telefone),email);
        editoras.add(editoraNova);
        return 0;
    }

    private int validarEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(regex)) {
            return 5;
        }
        return 0;
    }

    private int validarTelefone(String telefone) {

        String regex ="^[9]\\d{8}$$";

        if (!telefone.matches(regex)) {
            return 4;
        }
        return 0;

    }

    private int validarMorada(String morada) {

        //sempre verdadeiro tinha fazer se com o API da google
        return 0;
    }

    private int validarNomeEditora(String editoraNome) {

        if(validarNomeCarecteresEspeciais(editoraNome) != 0){
            return 1;
        }

        for (int i = 0; i < editoras.size(); i++) {
            Editora autorAux = editoras.get(i);
            if(autorAux.getNome().compareTo(editoraNome) == 0){
                return 2;
            }

        }
        return 0;
    }

    private int validarNomeCarecteresEspeciais(String nome){
        String regex = "[\\p{L}\\p{N}\\s\\.]+";
        if (!nome.matches(regex)) {
            return 1;
        }
        return 0;
    }

    public int confirmarDadosLivro(String titulo, List<Autor> listaAutores, EnumSet<Genero> valoresGen, EnumSet<SubGenero> valoresSub, String editora, String quantidade, String ano, String numEdicao, String isbn, String sala, String estante, String prateleira, String sinopse) {

        int num_quant;
        try{
            num_quant = Integer.valueOf(quantidade);

        }catch (NumberFormatException e ){
            return 12;
        }

        int num_ano;
        try{
            num_ano = Integer.valueOf(ano);

        }catch (NumberFormatException e ){
            return 5;
        }

        int num_isbn;
        try{
            num_isbn = Integer.valueOf(isbn);

        }catch (NumberFormatException e ){
            return 6;
        }

        int num_edi;
        try{
            num_edi = Integer.valueOf(numEdicao);

        }catch (NumberFormatException e ){
            return 13;
        }


        int flag = 0;
        //pode haver titulos iguais mas tem de ter autores diferentes
        flag = validarTituloAutores(titulo,listaAutores);
        if( flag != 0){
            return flag;
        }

        flag = validarGeneroSubGenero(valoresGen,valoresSub);
        if( flag != 0){
            return flag;
        }

        flag = validarEditoraDadosLivros(editora);
        if( flag != 0){
            return flag;
        }

        flag = validarQuantidade(num_quant);
        if( flag != 0){
            return flag;
        }

        flag = validarAno(num_ano);
        if( flag != 0){
            return flag;
        }

        flag = validarSinopse(sinopse);
        if( flag != 0){
            return flag;
        }

        flag = validarPrateleiraSalaEstante(sala,prateleira,estante);
        if( flag != 0){
            return flag;
        }



        return 0;
    }

    private int validarPrateleiraSalaEstante(String sala, String prateleira, String estante) {
        //String regex = "[^a-zA-Z0-9\\s\\.]+";
        String regex = "[\\p{L}\\p{N}\\s\\.]+";

        if (!sala.matches(regex)) {
            return 10;
        }

        if (!prateleira.matches(regex)) {
            return 10;
        }

        if (!estante.matches(regex)) {
            return 10;
        }

        return 0;
    }

    private int validarSinopse(String sinopse) {

        if(sinopse.length() > 500){
            return 9;
        }

        return 0;
    }

    private int validarAno(int numAno) {

        LocalDate hoje = LocalDate.now();
        int ano = hoje.getYear();

        if(numAno > ano){
            return 8;
        }

        return 0;
    }

    private int validarQuantidade(int numQuant) {
        if(numQuant <= 0 || numQuant >=6){
            return 7;
        }

        return 0;
    }

    private int validarEditoraDadosLivros(String editora) {

        if(validarNomeCarecteresEspeciais(editora) != 0){
            return 3;
        }

        for (int i = 0; i < editoras.size(); i++) {
            Editora autorAux = editoras.get(i);
            if(autorAux.getNome().compareTo(editora) == 0){
                return 0;
            }

        }

        return 4;
    }

    private int validarGeneroSubGenero(EnumSet<Genero> valoresGen, EnumSet<SubGenero> valoresSub) {
        //tem de selecionar pelo menos 1 de cada

        if(valoresGen.size() == 0 && valoresSub.size() == 0){
            return 2;
        }

        return 0;
    }

    private int validarTituloAutores(String titulo, List<Autor> listaAutores) {

        if(listaAutores.size() == 0){
            return 11;
        }

        for (int i = 0; i < livros.size(); i++) {
            Livro livroAux = livros.get(i);
            //encontrou livro com o mesmo titulo tem de verificar todos os autores. pelo menos 1 tem de ser diferente
            if(livroAux.getTitulo().compareTo(titulo) == 0){
                List<Autor> listaAux = livroAux.getListaAutores();
                int size = listaAux.size();
                int contador = 0;

                for (int j = 0; j < size; j++) {
                    String nomeAutor = listaAux.get(j).getNome();

                    for (int k = 0; k < listaAutores.size(); k++) {
                        String nomeAutorAux = listaAutores.get(k).getNome();
                        if(nomeAutor.compareTo(nomeAutorAux) == 0){
                            contador++;
                        }

                    }
                }
                //mesmos autores
                if(contador == size){
                    return 1;
                }else{
                    return 0;
                }
            }
        }

        //nao encontrou nenhum livro com o mesmo titulo entao nao é necessário verificar autores
        return 0;
    }

    public Autor encontrarAutor(String autorNome){
        for (int i = 0; i < autores.size(); i++) {
            Autor autorAux = autores.get(i);
            if(autorAux.getNome().compareTo(autorNome) == 0){
                return autorAux;
            }

        }
        return null;
    }

    public int confirmarCodigoEGuardarLivros(Livro livro, String[] codigoLivrosString) {
        int quantidade = livro.getQuantidade();

        int [] codigosLivros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            try{
                codigosLivros[i] = Integer.valueOf(codigoLivrosString[i]);

            }catch (NumberFormatException e ){
                return 1;
            }
        }

        int flag = 0;

        flag = validarCodigos(livro,codigosLivros);
        if( flag != 0){
            return flag;
        }

        return guardarDadosLivros(livro,codigosLivros);
    }

    private int guardarDadosLivros(Livro livro, int[] codigosLivros) {
        livros.add(livro);

        for (int i = 0; i < livro.getQuantidade(); i++) {
            LivroInstancia livroInstancia = new LivroInstancia(livro.getTitulo(),livro.getListaAutores(),livro.getQuantidade(),livro.getListaGeneros(),
                    livro.getListaSubGenero(),livro.getEditora(),livro.getAno(),livro.getEdicao(),livro.getISBN(),livro.getPrateleira(),livro.getEstante(),livro.getSala(),
                    livro.getSinopse(),codigosLivros[i]);

            livrosExemplares.add(livroInstancia);
        }

        return 0;
    }

    private int validarCodigos(Livro livro, int[] codigosLivros) {
        int quantidade = livro.getQuantidade();

        //verifica se o mesmo codigo nao está a ser introduzido
        for (int i = 0; i < quantidade-1; i++) {


            for (int j = i+1; j < quantidade; j++) {

                if( codigosLivros[i] == codigosLivros[j]){
                    return 2;
                }
            }
        }

        for (int i = 0; i < quantidade; i++) {
            for (int j = 0; j < livrosExemplares.size(); j++) {
                if(livrosExemplares.get(j).getCodigoLivro() == codigosLivros[i]){
                    return 3;
                }
            }
        }

    return 0;
    }

    public List<Socio> getSociosComMulta() {
        List<Socio> listaSocioComMulta = new ArrayList<>();
        for (int i = 0; i < getSocios().size(); i++) {
            Socio socio = getSocios().get(i);
            if(socio.getMulta()>0){
                listaSocioComMulta.add(socio);
            }

        }
        return listaSocioComMulta;
    }

    public int registarSocio(String nomeSocio, char generoSocio, String dataDeNacimentoSocio, String nifSocio, String telefoneSocio, String emailSocio, String moradaSocio, String autorPreferidoSocio, List<SubGenero> selecionados) {

        int numNIFSocio = Integer.valueOf(nifSocio);
        int nrTelefoneSocio = Integer.valueOf(telefoneSocio);
        int dia, mes, ano;

        String[] partes = dataDeNacimentoSocio.split("/");

        dia = Integer.parseInt(partes[0]);
        mes = Integer.parseInt(partes[1]);
        ano = Integer.parseInt(partes[2]);

        Date dataNascimento = new Date(dia, mes, ano);

        LocalDate dataNascimentoSocio = LocalDate.of(ano, mes, dia);


        for (Socio socio : socios) {
            if (socio.getNif() == numNIFSocio) {
                return -1; // NIF já existe
            }
        }


        boolean autorExiste = autores.stream().anyMatch(autor -> autor.getNome().equals(autorPreferidoSocio));



        if(autorPreferidoSocio == null || autorPreferidoSocio.isEmpty()){autorExiste = true;}

        if (!autorExiste ) {
            return -2;
        }

        List<Autor> autoresEncontrados = new ArrayList<>();
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(autorPreferidoSocio)) {
                autoresEncontrados.add(autor);
            }
        }


        if (generoSocio != 'M' && generoSocio != 'F' && generoSocio != 'O') {
            return -3; //genero errado
        }

        LocalDate hoje = LocalDate.now();
        LocalDate verificarData = LocalDate.now();

        int diaAnuidade = hoje.getDayOfMonth();
        int mesAnuidade = hoje.getMonthValue();
        int anoAnuidade = hoje.getYear()+1;

        Date dataAnuidadeSocio = new Date(diaAnuidade, mesAnuidade, anoAnuidade);

        if (dataAnuidadeSocio.getYear() > dataNascimentoSocio.getYear() ||
                (dataAnuidadeSocio.getYear() == dataNascimentoSocio.getYear() &&
                        verificarData.getMonthValue() > dataNascimentoSocio.getMonthValue()) ||
                (dataAnuidadeSocio.getYear() == dataNascimentoSocio.getYear() &&
                        verificarData.getMonthValue() == dataNascimentoSocio.getMonthValue() &&
                        verificarData.getDayOfMonth() > dataNascimentoSocio.getDayOfMonth())) {
            //Data de Nascimento ta corretas
        } else {
            return -4;
        }

        String numeroTelemovelString = String.valueOf(nrTelefoneSocio);

        String regex ="^9\\d{8}$";

        if (!numeroTelemovelString.matches(regex)) {
            return -5;
        }

        numeroSocios++;
        int numeroSocio = numeroSocios;




        Socio novoSocio = new Socio(nomeSocio, moradaSocio, nrTelefoneSocio, emailSocio, numNIFSocio,dataNascimento, generoSocio, dataAnuidadeSocio, numeroSocio, selecionados, autoresEncontrados);

        socios.add(novoSocio);

        return 0;

    }

    public List<Socio> procurarSocio(String nomePesquisa) {
        List<Socio> sociosEncontrados = new ArrayList<>();

        boolean procurarPorPrimeiroNome = nomePesquisa.trim().split(" ").length == 1;

        for (Socio socio : socios) {
            if (procurarPorPrimeiroNome) {
                String primeiroNome = socio.getNome().split(" ")[0];
                if (primeiroNome.equalsIgnoreCase(nomePesquisa)) {
                    sociosEncontrados.add(socio);
                }
            } else {
                if (socio.getNome().equalsIgnoreCase(nomePesquisa)) {
                    sociosEncontrados.add(socio);
                }
            }
        }

        return sociosEncontrados;
    }

    public int eliminarSocio(Socio socio) {
        socios.remove(socio);
        return 0;
    }

    public int pagar(Socio socio) {

        LocalDate hoje = LocalDate.now();
        int novoDiaAnuidade = hoje.getDayOfMonth();
        int novoMesAnuidade = hoje.getMonthValue();
        int novoAnoAnuidade = socio.getDataAnuidade().getYear() + 1;


        socio.setDataAnuidade(novoDiaAnuidade, novoMesAnuidade, novoAnoAnuidade);


        socio.pagar();

        return 0;
    }

    public List<Requisicao> getHistoricoRequisicoes(Socio socio) {
        return socio.getListaRequisicoes();
    }

    public List<LivroInstancia> getLivrosRequisitados(Socio socio) {
        return socio.getlistaLivrosRequisitadosAtualmente();
    }
}