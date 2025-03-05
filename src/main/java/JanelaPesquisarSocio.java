import models.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class JanelaPesquisarSocio extends JFrame {

    private JPanel panel;
    private JTextField nomePesquisar;
    private JButton pesquisarButton;

    public JanelaPesquisarSocio() {

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
        setTitle("Pesquisar Socio");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(47, 54, 154));


        // Set the frame to be visible
        setVisible(true);
        pesquisarButton.addActionListener(this::btnPesquisarActionPerformed);
    }


    private void btnPesquisarActionPerformed(ActionEvent e) {

       List<Socio> sociosEncontrados;

        sociosEncontrados = Repositorio.getInstance().procurarSocio(nomePesquisar.getText());

        if(sociosEncontrados == null || sociosEncontrados.isEmpty()){
            //Janela com mensagem erro
            new JanelaListaSociosMensagem("Sem resultados encontrados");
            this.dispose();
        }else{
            //JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
            new JanelaListaDeSocios(sociosEncontrados, nomePesquisar.getText());
            this.dispose();
        }
    }


}
