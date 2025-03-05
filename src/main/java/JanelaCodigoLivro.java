import models.Editora;
import models.Genero;
import models.Livro;
import models.SubGenero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JanelaCodigoLivro extends JFrame{

    private JPanel panel;
    private JButton confirmarButton;
    private JPanel panelCodigo;
    private JTextField[] textFields;
    private Livro livro;
    private JFrame frameAnterior;

    public JanelaCodigoLivro(Livro livro, JFrame frameAnterior) {

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
        setTitle("Adicionar Livro - Codigo");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));



        this.livro = livro;

        int quantidade = this.livro.getQuantidade();
        textFields = new JTextField[quantidade];
        panelCodigo.setLayout(new GridLayout(quantidade,2));

        for (int i = 0; i < quantidade; i++) {
            JLabel label = new JLabel("Codigo do Livro " + (i + 1));
            JTextField textField = new JTextField();
            textFields[i] = textField; // Store reference to the text field
            panelCodigo.add(label);
            panelCodigo.add(textField);
        }

        this.frameAnterior = frameAnterior;

        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);

    }

    private void btnConfrimarActionPerformed(ActionEvent e) {
        int quantidade = livro.getQuantidade();
        String[] codigoLivrosString = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            codigoLivrosString[i] = textFields[i].getText();
        }
        int valorRetorno = Repositorio.getInstance().confirmarCodigoEGuardarLivros(livro,codigoLivrosString);

        if(valorRetorno == 0){
            this.dispose();
            frameAnterior.dispose();
            JOptionPane.showMessageDialog(null, livro.getTitulo() + " adicionados com sucesso" + "\n");

        }else{
            JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
        }
    }

    private String mensagemErro(int flag){
        String mensagemErro = null;
        switch(flag) {
            case 1:
                mensagemErro = "Os codigos tem de ser numeros";
                break;
            case 2:
                mensagemErro = "Existe codigos inseridos iguais";
                break;
            case 3:
                mensagemErro = "Existe codigos na base de dados";
                break;
            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }

}
