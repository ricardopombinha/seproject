import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JanelaRequisitarLivro extends JFrame {

    private JPanel panel;
    private JButton confirmarButton;
    private JTextField nomeLivro;
    private JTextField nomeAutor;
    private JTextField nomeSocio;
    private JTextField numeroSocio;
    private JTextField tempo;
    private JTextField codigoLivro;

    public JanelaRequisitarLivro() {

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
        setTitle("Requistar Livro");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));

        // Create the panel to hold the form components
        /*JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6); // Add padding

        JLabel titleLabel = new JLabel("Requisitar Livro", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        gbc.gridx = 0;
        gbc.gridy = -1;
        panel.add(titleLabel, gbc);

        // Add labels and text fields to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nome do Livro:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nomeLivroField = new JTextField(20);
        panel.add(nomeLivroField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nome do Autor:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nomeAutorField = new JTextField(20);
        panel.add(nomeAutorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nome do Sócio:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nomeSocioField = new JTextField(20);
        panel.add(nomeSocioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Nª Sócio:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField numeroSocioField = new JTextField(20);
        panel.add(numeroSocioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Tempo pretendido de Requisição:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField tempoRequisicaoField = new JTextField(20);
        panel.add(tempoRequisicaoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Código do Livro:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField codigoLivroField = new JTextField(20);
        panel.add(codigoLivroField, gbc);

        // Add the panel to the frame
        add(panel);*/

        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
    }

    //criaçao de requisiçãoa traves do butao de requisição
    public JanelaRequisitarLivro(String tituloLivro, String autorNome) {

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
        setTitle("Requistar Livro");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));

        nomeLivro.setText(tituloLivro);
        nomeAutor.setText(autorNome);

        // Set the frame to be visible
        setVisible(true);
        confirmarButton.addActionListener(this::btnConfrimarActionPerformed);
    }

    private void btnConfrimarActionPerformed(ActionEvent e) {
        int valorRetorno = Repositorio.getInstance().confimarEGuardarRequisicao(nomeLivro.getText(),nomeAutor.getText(),nomeSocio.getText(),numeroSocio.getText(),tempo.getText(),codigoLivro.getText());

        if(valorRetorno == 0){
            //nova janela
            new JanelaRequisitarMensagem(nomeLivro.getText() + " #" + codigoLivro.getText() +"\n" +
                    "Requisitado com sucesso");
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
            default:
                mensagemErro = "Erro desconhecido";
                break;
        }

        return mensagemErro;
    }

}


