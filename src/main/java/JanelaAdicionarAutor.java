import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaAdicionarAutor extends JFrame {
    private JPanel panel;
    private JTextField nomeAutor;
    private JButton confirmarButton;

    public JanelaAdicionarAutor() {

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

        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
    }

    private void btnConfrimarActionPerformed(ActionEvent e) {
        int valorRetorno = Repositorio.getInstance().confimarEGuardarAutor(nomeAutor.getText());

        if(valorRetorno == 0){
            this.dispose();
            JOptionPane.showMessageDialog(null,nomeAutor.getText() + " registado com Sucesso" +"\n");

        }else{
            JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
        }
    }

    private String mensagemErro(int flag){
        String mensagemErro = null;
        switch(flag) {
            case 1:
                mensagemErro = "O nome do autor tem caracteres especiais";
                break;
            case 2:
                mensagemErro = "O nome do autor  existe na base de dados";
                break;

            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }


}
