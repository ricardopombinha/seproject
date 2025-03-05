import models.Livro;
import models.LivroInstancia;
import models.Socio;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JanelaSociosQueRequisitaram extends JFrame {
    private Livro livro;

    public JanelaSociosQueRequisitaram(Livro livro) {
        this.livro = livro;

        setTitle("Sócios que Requisitaram o Livro");
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
        JLabel tituloLabel = new JLabel("Sócios que Requisitaram o Livro");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        // Espaço entre o título e a lista de sócios
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.setBackground(new Color(40, 42, 67));

        // Obter a lista de sócios que requisitaram o livro
        List<Socio> socios = Repositorio.getInstance().getSociosComLivroRequisitado(livro);
        // Adicionar um painel para cada sócio na lista
        for (Socio socio : socios) {
            if(socio.getRequisicaoAtivasNumero() == 0){
                continue;
            }
            for(LivroInstancia livroInstancia :socio.getlistaLivrosRequisitadosAtualmente()){
                if(livroInstancia.isRequisitado() && livroInstancia.getISBN() == livro.getISBN()){
                    JPanel socioPanel = new JPanel();
                    socioPanel.setLayout(new BoxLayout(socioPanel, BoxLayout.X_AXIS));
                    socioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    socioPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item
                    socioPanel.setBackground(new Color(40, 42, 67));

                    JLabel nomeLabel = new JLabel(socio.getNome());
                    nomeLabel.setForeground(Color.WHITE);
                    nomeLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de nome
                    socioPanel.add(nomeLabel);

                    socioPanel.add(Box.createHorizontalGlue()); // Adiciona espaço flexível entre o nome e o botão

                    JButton btnDevolverLivro = new JButton("Devolver Livro");
                    btnDevolverLivro.addActionListener(e -> devolverLivro(socio, livroInstancia));
                    socioPanel.add(btnDevolverLivro);

                    panel.add(socioPanel);

                    // Espaço entre os itens da lista (muito pequeno)
                    panel.add(Box.createRigidArea(new Dimension(0, 2)));
                }

            }


        }

        /*List<LivroInstancia> livrosInstancias = Repositorio.getInstance().getLivrosExemplares();
        for (LivroInstancia livroInstancia : livrosInstancias) {
            JPanel socioPanel = new JPanel();
            socioPanel.setLayout(new BoxLayout(socioPanel, BoxLayout.X_AXIS));
            socioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            socioPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item
            socioPanel.setBackground(new Color(40, 42, 67));

            JLabel nomeLabel = new JLabel(socio.getNome());
            nomeLabel.setForeground(Color.WHITE);
            nomeLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de nome
            socioPanel.add(nomeLabel);

            socioPanel.add(Box.createHorizontalGlue()); // Adiciona espaço flexível entre o nome e o botão

            JButton btnDevolverLivro = new JButton("Devolver Livro");
            btnDevolverLivro.addActionListener(e -> devolverLivro(socio, livro));
            socioPanel.add(btnDevolverLivro);

            panel.add(socioPanel);

            // Espaço entre os itens da lista (muito pequeno)
            panel.add(Box.createRigidArea(new Dimension(0, 2)));
        }*/

        setVisible(true);
    }

    private void devolverLivro(Socio socio, LivroInstancia livro) {
        Repositorio.getInstance().devolverLivro(socio, livro);
        JOptionPane.showMessageDialog(this, "Livro devolvido");
        dispose(); // Fecha a janela após devolver o livro
    }
}
