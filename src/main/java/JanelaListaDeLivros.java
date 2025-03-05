import models.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class JanelaListaDeLivros extends JFrame {

    private JFrame frame;
    private JPanel panel;

    public JanelaListaDeLivros(List<Livro> resultados) {
        setTitle("Lista de Livros");
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

        // Criação do painel principal com layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);

        // Adicionar título
        JLabel tituloLabel = new JLabel("Lista de Livros");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        // Espaço entre o título e a lista de livros
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.setBackground(new Color(50, 52, 77));
        // Adiciona um painel para cada livro na lista
        for (Livro livro : resultados) {
            JPanel livroPanel = new JPanel();
            livroPanel.setLayout(new BoxLayout(livroPanel, BoxLayout.X_AXIS));
            livroPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            livroPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item
            livroPanel.setBackground(new Color(50, 52, 77)); // Cor de fundo do painel do livro

            JLabel tituloLivroLabel = new JLabel("Título: " + livro.getTitulo());
            tituloLivroLabel.setForeground(Color.WHITE);
            tituloLivroLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de título
            livroPanel.add(tituloLivroLabel);

            livroPanel.add(Box.createHorizontalGlue()); // Adiciona espaço flexível entre o título e o botão

            JButton detalhesButton = new JButton("Ver Detalhes");
            detalhesButton.setPreferredSize(new Dimension(120, 20)); // Ajuste do tamanho do botão
            detalhesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    abrirDetalhesLivro(livro);
                }
            });
            livroPanel.add(detalhesButton);

            panel.add(livroPanel);

            // Espaço entre os itens da lista (muito pequeno)
            panel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        setVisible(true); // Torna a janela visível após configurar todos os componentes
    }

    private void abrirDetalhesLivro(Livro livro) {
        JanelaInfoLivro detalhesLivro = new JanelaInfoLivro(livro);

    }
}
