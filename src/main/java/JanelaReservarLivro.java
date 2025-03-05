import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaReservarLivro extends JFrame {
    private JButton confirmarButton;
    private JTextField nomeLivro;
    private JTextField nomeAutor;
    private JTextField nomeSocio;
    private JTextField numeroSocio;
    private JTextField tempo;
    private JPanel panel;


    public JanelaReservarLivro() {

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
        setTitle("Reservar Livro");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));


        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
    }

    private void btnConfrimarActionPerformed(ActionEvent e) {
        int valorRetorno = Repositorio.getInstance().confimarEGuardarReserva(nomeLivro.getText(),nomeAutor.getText(),nomeSocio.getText(),numeroSocio.getText(),tempo.getText());

        if(valorRetorno == 0){
            //nova janela
            new JanelaReservarLivroMensagem(nomeLivro.getText() + ", Reservado com suceso" +"\n" +
                    "Será notificado quando tiver disponivel");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, mensagemErro(valorRetorno));
        }
    }

    private String mensagemErro(int flag){
        String mensagemErro = null;
        switch(flag) {
            case 1:
                mensagemErro = "O nome do livro não existe na base de dados";
                break;
            case 2:
                mensagemErro = "O autor não existe na base de dados";
                break;
            case 3:
                mensagemErro = "O autor não escreveu esse livro";
                break;
            case 4:
                mensagemErro = "O tempo pretendido tem de ser maior ou igual que 1 e menor ou igual que 15";
                break;
            case 5:
                mensagemErro = "O tempo pretendido tem de ser um numero";
                break;
            case 6:
                mensagemErro = "O codigo do livro tem de pertencer ao livro que se quer requisitar";
                break;
            case 7:
                mensagemErro = "O livro com esse codigo está requisitado atualmente";
                break;
            case 8:
                mensagemErro = "O sócio já atingiu o limite máximo de requisições,4";
                break;
            case 9:
                mensagemErro = "O sócio tem multas para pagar";
                break;
            case 10:
                mensagemErro = "O sócio nao encontrado";
                break;
            case 11:
                mensagemErro = "O nome do sócio está incorreto";
                break;
            case 12:
                mensagemErro = "O numero de sócio tem de ser um numero ou nao pode ser um numero muito grande";
                break;
            case 13:
                mensagemErro = "O tempo de dias tem de ser um numero ou nao pode ser um numero muito grande";
                break;
            case 14:
                mensagemErro = "O codigo do livro tem de ser um numero ou nao pode ser um numero muito grande";
                break;
            case 15:
                mensagemErro = "Existe um livro disponivel para requisitar";
                break;
            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }

}
