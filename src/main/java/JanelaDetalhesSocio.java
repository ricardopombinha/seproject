import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.stream.Collectors;

public class JanelaDetalhesSocio extends JFrame{
    private JPanel panel1;
    private JLabel nomeSocio;
    private JLabel dataNascimentoSocio;
    private JLabel telefoneSocio;
    private JLabel generoSocio;
    private JLabel nifSocio;
    private JLabel moradaSocio;
    private JLabel emailSocio;
    private JLabel anuidadeSocio;
    private JLabel multaSocio;
    private JLabel generosFavoritos;
    private JLabel autorFavorito;
    private JButton alterarButton;
    private JButton livrosRequisitadosButton;
    private JButton verReservasButton;
    private JButton históricoDeRequisiçõesButton;
    private JButton eliminarSócioButton;
    private JButton pagarAnuidadeButton;
    private JLabel numeroSocio;

    public JanelaDetalhesSocio(Socio socio) {

        // Set the default close operation
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the JFrame to be a bit smaller than the screen size
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        setSize(width, height);

        // Center the JFrame on the screen
        // Set up the frame
        setTitle("Detalhes do Sócio");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel1.setBackground(new Color(241, 241, 241));

        String multaString = String.valueOf(socio.getMulta());
        String generoString = String.valueOf(socio.getGenero());
        String dataNascimentoString = String.valueOf(socio.getDataNascimento());
        String telefoneString = String.valueOf(socio.getTelefone());
        String nifString = String.valueOf(socio.getNif());
        String anuidadeString = String.valueOf(socio.getDataAnuidade());

        String generosFav = null;

        List<SubGenero> listaGeneros = socio.getListaGeneros();
        List<Autor> listaAutores = socio.getListaAutores();

        if(listaGeneros != null){
            generosFav = listaGeneros.stream().map(Enum::name).collect(Collectors.joining(", "));
        }

        String autoresFav = null;

        if(listaAutores != null){
            autoresFav = listaParaString(listaAutores);
        }


        nomeSocio.setText(socio.getNome());
        multaSocio.setText(multaString);
        generoSocio.setText(generoString);
        dataNascimentoSocio.setText(dataNascimentoString);
        telefoneSocio.setText(telefoneString);
        moradaSocio.setText(socio.getMorada());
        nifSocio.setText(nifString);
        emailSocio.setText(socio.getEmail());
        anuidadeSocio.setText(anuidadeString);
        numeroSocio.setText(String.valueOf(socio.getNumeroSocio()));

        if(listaGeneros != null){
            generosFavoritos.setText(generosFav);
        }
        if(listaAutores != null){
            autorFavorito.setText(autoresFav);
        }
        // Set the frame to be visible
        setVisible(true);
        eliminarSócioButton.addActionListener(e->btnEliminarActionPerformed(socio));

        pagarAnuidadeButton.addActionListener(e->btnPagarAnuidadeActionPerformed(socio));

        livrosRequisitadosButton.addActionListener(e->btnVerLivrosRequisitadosActionPerformed(socio));

        históricoDeRequisiçõesButton.addActionListener(e->btnVerHistoricoRequisicoesActionPerformed(socio));
    }

    private void btnVerHistoricoRequisicoesActionPerformed(Socio socio) {
        List<Requisicao> listaHistoricoRequisicoes = Repositorio.getInstance().getHistoricoRequisicoes(socio);

        if(listaHistoricoRequisicoes.isEmpty()){
            new JanelaListaSociosMensagem("Sócio sem requisições feitas");

        }else{new JanelaHistoricoDeLivrosRequisitados(listaHistoricoRequisicoes);}


    }

    private void btnVerLivrosRequisitadosActionPerformed(Socio socio) {
        List<LivroInstancia> listaRequisicoes = Repositorio.getInstance().getLivrosRequisitados(socio);

        if(listaRequisicoes.isEmpty()){
            new JanelaSociosMensagem("Sócio sem livros requisitados");

        }else{new JanelaRequisicoesDoSocio(listaRequisicoes);}


        //new JanelaSociosMensagem("Sócio com requisições ativas");

    }

    private void btnPagarAnuidadeActionPerformed(Socio socio) {



        int valorRetorno = Repositorio.getInstance().pagar(socio);

        if(valorRetorno == 0){
            //nova janela
            new JanelaSociosMensagem("Anuidade e Multa Paga com sucesso \n Próxima anuidade: " + socio.getDataAnuidade());

        }
    }


    private void btnEliminarActionPerformed(Socio socio) {

        //Ir ao repositorio eliminar socio



        int valorRetorno = Repositorio.getInstance().eliminarSocio(socio);

        if(valorRetorno == 0){
            //nova janela
            new JanelaSociosMensagem(nomeSocio.getText() + " " +
                    "Eliminado com sucesso");
            this.dispose();
        }
    }

    private static String listaParaString(List<Autor> lista) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i).getNome()); // Obtém o nome do autor
            if (i < lista.size() - 1) {
                sb.append(", "); // Adiciona vírgula se não for o último elemento
            }
        }
        return sb.toString();
    }


}
