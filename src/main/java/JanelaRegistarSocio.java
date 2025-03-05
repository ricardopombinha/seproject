import models.SubGenero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class JanelaRegistarSocio extends JFrame {

    private JPanel panel;
    private JButton confirmarButton;
    private JTextField nomeSocio;
    private JTextField generoSocio;
    private JTextField DataDeNascimentoSocio;
    private JTextField nifSocio;
    private JTextField telefoneSocio;
    private JTextField moradaSocio;
    private JCheckBox novelaCheckBox;
    private JCheckBox romanceCheckBox;
    private JCheckBox horrorCheckBox;
    private JCheckBox infantilCheckBox;
    private JCheckBox fantásticoCheckBox;
    private JCheckBox ficcaoPolicialCheckBox;
    private JCheckBox ficcaoCientificaCheckBox;
    private JCheckBox contoCheckBox;
    private JTextField autorPreferido;
    private JTextField emailSocio;

    public JanelaRegistarSocio() {

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
        setTitle("Registar Socio");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(47, 54, 154));


        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
    }


    private void btnConfrimarActionPerformed(ActionEvent e) {

        List<SubGenero> selecionados = getSelecionados();



        int valorRetorno = Repositorio.getInstance().registarSocio(nomeSocio.getText(),generoSocio.getText().charAt(0),DataDeNascimentoSocio.getText(),nifSocio.getText(), telefoneSocio.getText(), emailSocio.getText(),moradaSocio.getText(), autorPreferido.getText(), selecionados);

        if(valorRetorno == 0){
            //nova janela
            new JanelaSociosMensagem(nomeSocio.getText() + " " +
                    "Registado com sucesso");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
        }
    }

    private List<SubGenero> getSelecionados() {
        List<SubGenero> selecionados = new ArrayList<>();
        if (novelaCheckBox.isSelected()) selecionados.add(SubGenero.Novela);
        if (romanceCheckBox.isSelected()) selecionados.add(SubGenero.Romance);
        if (horrorCheckBox.isSelected()) selecionados.add(SubGenero.Horror);
        if (infantilCheckBox.isSelected()) selecionados.add(SubGenero.Infantil);
        if (fantásticoCheckBox.isSelected()) selecionados.add(SubGenero.Fantasia);
        if (ficcaoPolicialCheckBox.isSelected()) selecionados.add(SubGenero.FicçãoPolicial);
        if (ficcaoCientificaCheckBox.isSelected()) selecionados.add(SubGenero.FicçãoCientífica);
        if (contoCheckBox.isSelected()) selecionados.add(SubGenero.Conto);
        return selecionados;
    }

    private String mensagemErro(int flag){
        String mensagemErro = null;
        switch(flag) {
            case -1:
                mensagemErro = "NIF já presente no sistema";
                break;
            case -2:
                mensagemErro = "O autor não existe na base de dados";
                break;
            case -3:
                mensagemErro = "Género inválido";
                break;
            case -4:
                mensagemErro = "Data de Nascimento inválida";
                break;
            case -5:
                mensagemErro = "Numero Telefone Invalido: [9XXXXXXXX]";
                break;
            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }

}
