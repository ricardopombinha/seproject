import models.Livro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class JanelaInfoLivro extends JFrame{

    private JFrame frame;
    private JPanel panel;
    private Livro livro;

    public JanelaInfoLivro(Livro livro) {
        this.livro = livro;

        setTitle("Detalhes do Livro");
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

        // Use GridBagLayout for flexible layout management
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(40, 42, 67));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add labels with book details
        addLabel(panel, constraints, "Título: ", livro.getTitulo());
        addLabel(panel, constraints, "Autor/es: ", String.valueOf(livro.getListaAutores()) );
        addLabel(panel, constraints, "Editora: ", livro.getEditora().getNome());
        addLabel(panel, constraints, "Quantidade Total: ", String.valueOf(livro.getQuantidade()));
        // addLabel(panel, constraints, "Quantidade Disponível: ", String.valueOf(livro.getQuantidadeDisponivel()));
        addLabel(panel, constraints, "Gênero: ", String.valueOf(livro.getListaGeneros()) );
        addLabel(panel, constraints, "Sub-Gênero: ", String.valueOf(livro.getListaSubGenero()) );
        addLabel(panel, constraints, "Ano: ", String.valueOf(livro.getAno()));
        addLabel(panel, constraints, "Localização: ", livro.getPrateleira() + livro.getEstante() + livro.getSala());
        addLabel(panel, constraints, "ISBN: ", String.valueOf(livro.getISBN()));
        addLabel(panel, constraints, "Número de Edição: ", String.valueOf(livro.getEdicao()));
        addLabel(panel, constraints, "Sinopse: ", livro.getSinopse());

        getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.addActionListener(e -> new JanelaSociosQueRequisitaram(livro).setVisible(true));

        JButton btnRequisicao = new JButton("Requisicao");
        btnRequisicao.addActionListener(e -> new JanelaRequisitarLivro(livro.getTitulo(), livro.getListaAutores().get(0).getNome()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(40, 42, 67));
        buttonPanel.add(btnDevolver);
        buttonPanel.add(btnRequisicao);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true); // Show the window
    }

    private void addLabel(JPanel panel, GridBagConstraints constraints, String labelText, String value) {
        JLabel label = new JLabel(labelText + value);
        label.setForeground(Color.WHITE);
        panel.add(label, constraints);
        constraints.gridy++;
    }
}
