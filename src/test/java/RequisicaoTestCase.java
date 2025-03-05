
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RequisicaoTestCase {


    @BeforeEach
    public void setUp(){
        //criar a isntancia
        Repositorio.setInstanceNull();
        Repositorio.getInstance();
    }
    @Test
    public void testCreateRequisicao() {

        LocalDate hoje = LocalDate.now();

        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        LivroInstancia livroInstancia = null;
        Date data = new Date(dia,mes,ano);
        for(int i = 0; i< Repositorio.getInstance().getLivrosExemplares().size(); i++){
            livroInstancia = Repositorio.getInstance().getLivrosExemplares().get(i);
            if(livroInstancia.getCodigoLivro() == 1){
                break;
            }
        }

        Requisicao requisicao = new Requisicao(4, "Antonio",1, data,livroInstancia);
        assertEquals(true, requisicao.isRequisicaoAtiva());
        assertEquals("Antonio", requisicao.getNomeSocio());
        assertEquals(1, requisicao.getNumeroSocio());
        assertEquals(data, requisicao.getDataEmprestimo());
        assertEquals(livroInstancia, requisicao.getLivroInstancia());
    }
    @Test
    public void testAddrequisicao(){
        int flag = Repositorio.getInstance().confimarEGuardarRequisicao("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4", "1");

        assertEquals(0, flag, "nao houve erros");
        assertEquals(1,Repositorio.getInstance().getRequisicoes().size(),"Nao acrescentei na lista");
        Socio socio = null;
        List<Socio> socios =  Repositorio.getInstance().getSocios();


        for (int i = 0; i < socios.size(); i++) {
            socio = socios.get(i);
            if(socio.getNumeroSocio() == 1){
                break;
            }

        }
        Requisicao requisicao = Repositorio.getInstance().getRequisicoes().get(0);

        assertEquals(1, socio.getRequisicaoAtivasNumero(), "Foi adicionado à lista do socio a requisiçao");
        assertEquals(1,socio.getListaRequisicoes().size(),"Foi adicionado ao historio a requisição do socio");
        assertEquals(requisicao,socio.getListaRequisicoes().get(0),"O repositorio e o socio nao tem realmente a mesma requisiçao");

    }


    @Test
    public void testRequisitarSameBookWhenNotAvailable(){

        Repositorio.getInstance().confimarEGuardarRequisicao("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4", "1");
        int flag = Repositorio.getInstance().confimarEGuardarRequisicao("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4", "1");

        assertEquals(7, flag, "Tem de ter o erro 7 pq este codigo diz se o livro já está requisitado");
        //assertEquals(1,Repositorio.getInstance().getRequisicoes().size(),"Nao acrescentei na lista");
    }
    @Test
    public void testReservarLivroAindaDisponivel(){

        int flag = Repositorio.getInstance().confimarEGuardarReserva("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4");

        assertEquals(15, flag, "Tem de ter o erro 15 pq este codigo diz que ainda há livros disponiveis para requisitar");
        //assertEquals(1,Repositorio.getInstance().getRequisicoes().size(),"Nao acrescentei na lista");
    }

    @Test
    public void testReservarLivro(){
        Repositorio.getInstance().confimarEGuardarRequisicao("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4", "1");
        Repositorio.getInstance().confimarEGuardarRequisicao("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4", "3");
        int flag = Repositorio.getInstance().confimarEGuardarReserva("One Piece Vol.1","Eichiro Oda", "Antonio", "1" , "4");

        assertEquals(0, flag, "Reserva feita com sucesso, todos os livros estão requisitados");
        assertEquals(2,Repositorio.getInstance().getRequisicoes().size(),"Nao acrescentei na lista de requisições");
        assertEquals(1,Repositorio.getInstance().getReservas().size(),"Nao acrescentei na lista de reservas");
    }

    @Test
    public void testCriarAutor(){
        int flag = Repositorio.getInstance().confimarEGuardarAutor("Eichiro Oda");

        assertNotEquals(0, flag, "Autor foi adicionado");

        flag = Repositorio.getInstance().confimarEGuardarAutor("Antonio Silva");


        assertEquals(0,flag,"Autor nao adicionado");
        assertEquals(4,Repositorio.getInstance().getAutores().size(),"Nao acrescentei na lista de autores");
    }
    @Test
    public void testCriarEditora(){
        int flag = Repositorio.getInstance().confimarEGuardarEditora("Devir", "Rua da ESTG", "916723232", "porto@mail.pt");

        assertEquals(2, flag, "Editora repetida flag de editora na base de dados");

        flag = Repositorio.getInstance().confimarEGuardarEditora("Dev@ir", "Rua da ESTG", "916723232", "porto@mail.pt");

        assertEquals(1, flag, "devia encontrar caracteres especiais");

        flag = Repositorio.getInstance().confimarEGuardarEditora("EdicoesEstg", "Rua da ESTG", "816723232", "porto@mail.pt");

        assertEquals(4, flag, "Nao começa com 9");

        flag = Repositorio.getInstance().confimarEGuardarEditora("EdicoesEstg", "Rua da ESTG", "916723232", "porto@mail");

        assertEquals(5, flag, "Nao corresponde a mail");

        flag = Repositorio.getInstance().confimarEGuardarEditora("EdicoesEstg", "Rua da ESTG", "916723232", "porto@mail.pt");


        assertEquals(0,flag,"Editora nao adicionado");
        assertEquals(4,Repositorio.getInstance().getEditoras().size(),"Nao acrescentei na lista de autores");
    }
}
