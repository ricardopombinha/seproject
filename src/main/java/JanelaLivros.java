import models.Livro;
import models.Genero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class JanelaLivros extends JFrame {

    private JPanel panel;
    private JButton btnPesquisar;
    private JButton confirmarButton;

    public JanelaLivros() {
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
        JLabel titleLabel = new JLabel("Livros", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setOpaque(false); // To make sure the panel background is transparent

        // Create the buttons
        JButton pesquisarButton = new JButton("Pesquisar Livro");
        JButton topLivrosButton = new JButton("Top Livros Requisitados");
        JButton adicionarButton = new JButton("Adicionar Livro");

        // Set button colors to gray
        pesquisarButton.setBackground(Color.GRAY);
        topLivrosButton.setBackground(Color.GRAY);
        adicionarButton.setBackground(Color.GRAY);

        // Set button size to medium
        Dimension buttonSize = new Dimension(400, 200);
        pesquisarButton.setPreferredSize(buttonSize);
        topLivrosButton.setPreferredSize(buttonSize);
        adicionarButton.setPreferredSize(buttonSize);

        // Add action listeners to the buttons
        pesquisarButton.addActionListener(this::btnPesquisarActionPerformed);
        topLivrosButton.addActionListener(this::btnTopLivrosActionPerformed);
        adicionarButton.addActionListener(this::btnAdicionarActionPerformed);

        // Add the buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(pesquisarButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(topLivrosButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(adicionarButton, gbc);

        // Add the label and button panel to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add the main panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void btnPesquisarActionPerformed(ActionEvent e) {
        // Create a new panel for the search interface
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));

        // Set the background color
        searchPanel.setBackground(new Color(40, 42, 67));

        // Add title label
        JLabel titleLabel = new JLabel("Pesquisar livros pelo título");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchPanel.add(titleLabel);

        // Add text field for title input
        JTextField titleField = new JTextField();
        titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, titleField.getPreferredSize().height));
        searchPanel.add(titleField);

        // Add checkboxes for filters
        String[] genres = {"Suspense", "Narrativo", "Fantasia", "B.Desenhada", "Poesia", "Matemática", "Física", "Contos"};
        List<JCheckBox> genreCheckBoxes = new ArrayList<>();
        for (String genre : genres) {
            JCheckBox checkBox = new JCheckBox(genre);
            checkBox.setForeground(Color.WHITE);
            checkBox.setBackground(new Color(40, 42, 67));
            genreCheckBoxes.add(checkBox);
            searchPanel.add(checkBox);
        }

        // Add search button
        JButton searchButton = new JButton("Pesquisar");
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(event -> {
            String titulo = titleField.getText();
            List<Genero> selectedGeneros = new ArrayList<>();
            for (JCheckBox checkBox : genreCheckBoxes) {
                if (checkBox.isSelected()) {
                    Genero genero = getGeneroFromString(checkBox.getText());

                    selectedGeneros.add(genero);

                    if (genero == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum livro com esse gênero encontrado.");
                    }
                }
            }
            List<Livro> resultados = Repositorio.getInstance().pesquisarLivros(titulo, selectedGeneros, new ArrayList<>()); // Assuming no sub-genres for simplicity

            if (!resultados.isEmpty())
                new JanelaListaDeLivros(resultados).setVisible(true);


        });
        searchPanel.add(searchButton);

        // Set up the new frame
        JFrame searchFrame = new JFrame();
        searchFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        searchFrame.setContentPane(searchPanel);

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the JFrame to be a bit smaller than the screen size
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        searchFrame.setSize(width, height);

        // Center the JFrame on the screen
        searchFrame.setTitle("Pesquisar Livro");
        searchFrame.setLocationRelativeTo(null);

        // Set the frame to be visible
        searchFrame.setVisible(true);
    }

    private Genero getGeneroFromString(String genero) {
        try {
            return Genero.valueOf(genero);

        } catch (IllegalArgumentException e) {
            System.out.println("Unknown genre: " + genero);
            return null;
        }
    }



    private void btnTopLivrosActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Top button clicked!");
    }

    private void btnAdicionarActionPerformed(ActionEvent e) {
        new JanelaAdicionarLivro();
    }
}
