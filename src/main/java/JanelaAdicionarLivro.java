import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JanelaAdicionarLivro extends JFrame {
    private JPanel panel;
    private JButton confirmarButton;
    private JTextField titulo;
    private JTextField autores;
    private JTextField editora;
    private JTextField quantidade;
    private JTextField ano;
    private JTextField numEdicao;
    private JTextField isbn;
    private JTextField sala;
    private JTextField estante;
    private JTextField praleiria;
    private JPanel panelGenSub;
    private JTextField sinopse;
    private JButton adicionarButton;
    private JPanel panelGen;
    private JPanel panelSub;
    private EnumSet<SubGenero> valoresSub;
    private EnumSet<Genero> valoresGen;
    private List<Autor> listaAutores;

    public JanelaAdicionarLivro() {

        // Set the default close operation
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panel);
        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the JFrame to be a bit smaller than the screen size
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        setSize(width, height);

        // Center the JFrame on the screen
        // Set up the frame
        setTitle("Adicionar Autor");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));

        valoresGen = EnumSet.noneOf(Genero.class);
        //fazer checkboxes
        panelGen.setLayout(new GridLayout(0,1));
        panelGen.setBackground(new Color(40, 42, 67));

        for (Genero value : Genero.values()) {
            JCheckBox checkBox = new JCheckBox(value.toString());
            checkBox.addItemListener(e -> {
                if (checkBox.isSelected()) {
                    valoresGen.add(value);

                } else {
                    valoresGen.remove(value);
                }

            });
            panelGen.add(checkBox);
        }

        valoresSub = EnumSet.noneOf(SubGenero.class);
        //fazer checkboxes
        panelSub.setLayout(new GridLayout(0,1));
        panelSub.setBackground(new Color(40, 42, 67));

        for (SubGenero value : SubGenero.values()) {
            JCheckBox checkBox = new JCheckBox(value.toString());
            checkBox.addItemListener(e -> {
                if (checkBox.isSelected()) {
                    valoresSub.add(value);

                } else {
                    valoresSub.remove(value);
                }

            });
            panelSub.add(checkBox);
        }

        listaAutores = new ArrayList<>();

        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);
    }

    private void btnConfrimarActionPerformed(ActionEvent e) {

        int valorRetorno = Repositorio.getInstance().confirmarDadosLivro(titulo.getText(),listaAutores,valoresGen,valoresSub,editora.getText(),quantidade.getText(),
                ano.getText(),numEdicao.getText(), isbn.getText(),sala.getText(),estante.getText(),praleiria.getText(), sinopse.getText());

        if(valorRetorno == 0){
            //this.dispose();
            List<Genero> generos = new ArrayList<>();
            List<SubGenero> subGeneros = new ArrayList<>();
            Editora editoraEscolhida = null;

            for (Genero value : valoresGen) {
                generos.add(value);
            }

            for (SubGenero value : valoresSub) {
                subGeneros.add(value);
            }

            for(Editora editoraAux : Repositorio.getInstance().getEditoras()){
                if(editoraAux.getNome().compareTo(editora.getText()) == 0){
                    editoraEscolhida = editoraAux;
                }
            }

            Livro livro = new Livro(titulo.getText(),listaAutores,Integer.valueOf(quantidade.getText()),generos,subGeneros,editoraEscolhida,
                    Integer.valueOf(ano.getText()),Integer.valueOf(numEdicao.getText()),Integer.valueOf(isbn.getText()),
                    praleiria.getText(),estante.getText(),sala.getText(),sinopse.getText());
            new JanelaCodigoLivro(livro, this);

        }else{
            JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
        }
    }

    private void btnAdicionarActionPerformed(ActionEvent e) {
            Autor autorNovo = Repositorio.getInstance().encontrarAutor(autores.getText());
            if(autorNovo != null){
                if(listaAutores.size() == 0){
                    JOptionPane.showMessageDialog(null,autores.getText() + " Adicionado aos autores do livro" +"\n");
                    listaAutores.add(autorNovo);
                }else{
                    for (int i = 0; i < listaAutores.size(); i++) {
                        Autor autorAux = listaAutores.get(i);
                        if(autorAux.getNome().compareTo(autorNovo.getNome()) == 0){
                            JOptionPane.showMessageDialog(null,"Autor já adicionado");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null,autores.getText() + " Adicionado aos autores do livro" +"\n");
                    listaAutores.add(autorNovo);
                }

            }
            else{
                JOptionPane.showMessageDialog(null,"Autor nao encontrado");
            }
    }




    private String mensagemErro(int flag){
        String mensagemErro = null;
        switch(flag) {
            case 1:
                mensagemErro = "O livro já existe na base de dados";
                break;
            case 2:
                mensagemErro = "Tem de escolher 1 género e 1 subgénero";
                break;
            case 3:
                mensagemErro = "O nome da editora tem caracteres especiais";
                break;
            case 4:
                mensagemErro = "A editora nao  existe na base de dados";
                break;
            case 5:
                mensagemErro = "O ano tem de ser um numero e nao pode ser extremamente grande";
                break;
            case 6:
                mensagemErro = "O ISBN tem de ser um numero e nao pode ser extremamente grande";
                break;
            case 7:
                mensagemErro = "A quantidade tem de ser entre 1 e 5";
                break;
            case 8:
                mensagemErro = "O Ano tem de ser atual ou anterior e não posterior";
                break;
            case 9:
                mensagemErro = "A sinopse nao pode ter mais que 500 caracteres";
                break;
            case 10:
                mensagemErro = "A sala, prateleira ou estante tem caracteres especias";
                break;
            case 11:
                mensagemErro = "Nenhum autor escolhido";
                break;
            case 12:
                mensagemErro = "A quantidade tem de ser um numero e nao pode ser extremamente grande";
                break;
            case 13:
                mensagemErro = "O numero de edição tem de ser um numero e nao pode ser extremamente grande";
                break;

            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }

}
