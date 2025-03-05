import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {

    public JanelaPrincipal() {
        // Set the title of the JFrame
        setTitle("Gestor Biblioteca");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        JLabel titleLabel = new JLabel("Gestor Biblioteca", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setOpaque(false); // To make sure the panel background is transparent

        // Create the buttons
        JButton sociosButton = new JButton("Sócios");
        JButton requisicoesButton = new JButton("Requisições");
        JButton livrosButton = new JButton("Livros");
        JButton gestaoButton = new JButton("Gestão Da Biblioteca");

        // Set button colors to gray
        sociosButton.setBackground(Color.GRAY);
        requisicoesButton.setBackground(Color.GRAY);
        livrosButton.setBackground(Color.GRAY);
        gestaoButton.setBackground(Color.GRAY);

        // Set button size to medium
        Dimension buttonSize = new Dimension(400, 200);
        sociosButton.setPreferredSize(buttonSize);
        requisicoesButton.setPreferredSize(buttonSize);
        livrosButton.setPreferredSize(buttonSize);
        gestaoButton.setPreferredSize(buttonSize);

        // Add action listeners to the buttons
        sociosButton.addActionListener(this::btnSocioActionPerformed);

        requisicoesButton.addActionListener(this::btnRequisicoesActionPerformed);

        livrosButton.addActionListener(this::btnLivrosActionPerformed);

        gestaoButton.addActionListener(this::btnGestaoActionPerformed);

        // Add the buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(sociosButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(requisicoesButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(livrosButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(gestaoButton, gbc);

        // Add the label and button panel to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Create and display the JFrame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal().setVisible(true);

            }
        });
    }

    private void btnSocioActionPerformed(ActionEvent e) {
        new JanelaSocios();
    }
    private void btnGestaoActionPerformed(ActionEvent e) {
        new JanelaGestaoBiblioteca();
    }
    private void btnRequisicoesActionPerformed(ActionEvent e) {
        new JanelaRequisicoes();
    }
    private void btnLivrosActionPerformed(ActionEvent e) {
        new JanelaLivros();
    }
}
