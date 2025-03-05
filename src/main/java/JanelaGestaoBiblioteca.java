import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JanelaGestaoBiblioteca extends JFrame {

    public JanelaGestaoBiblioteca() {

        // Set the default close operation
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the JFrame to be a bit smaller than the screen size
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        setSize(width, height);

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Set the background color to dark blue
        getContentPane().setBackground(new Color(40, 42, 67));

        // Create a panel to hold the label and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false); // To make sure the panel background is transparent

        // Create the label
        JLabel titleLabel = new JLabel("Gestão Da Biblioteca", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setOpaque(false); // To make sure the panel background is transparent

        // Create the buttons
        JButton pesquisarButton = new JButton("Pesquisar Livro");
        JButton sociosMultaButton = new JButton("Ver Sócios Com Multa");
        JButton autorButton = new JButton("Criar Autor");
        JButton editoraButton = new JButton("Criar Editora");

        // Set button colors to gray
        pesquisarButton.setBackground(Color.GRAY);
        sociosMultaButton.setBackground(Color.GRAY);
        autorButton.setBackground(Color.GRAY);
        editoraButton.setBackground(Color.GRAY);

        // Set button size to medium
        Dimension buttonSize = new Dimension(400, 200);
        pesquisarButton.setPreferredSize(buttonSize);
        sociosMultaButton.setPreferredSize(buttonSize);
        autorButton.setPreferredSize(buttonSize);
        editoraButton.setPreferredSize(buttonSize);

        // Add action listeners to the buttons
        pesquisarButton.addActionListener(this::btnPesquisarActionPerformed);

        sociosMultaButton.addActionListener(this::btnSociosMultaActionPerformed);

        autorButton.addActionListener(this::btnAutorActionPerformed);

        editoraButton.addActionListener(this::btnEditoraActionPerformed);


        // Add the buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(pesquisarButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(sociosMultaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(autorButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        buttonPanel.add(editoraButton, gbc);


        // Add the label and button panel to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void btnPesquisarActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Pesquisar button clicked!");
    }
    private void btnSociosMultaActionPerformed(ActionEvent e) {
        new JanelaSociosMulta();
    }
    private void btnAutorActionPerformed(ActionEvent e) {
        new JanelaAdicionarAutor();
    }

    private void btnEditoraActionPerformed(ActionEvent e) {
        new JanelaAdicionarEditora();
    }


}


