import models.LivroInstancia;
import models.Requisicao;
import models.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaRequisicoesDoSocio extends JFrame {

    private final List<LivroInstancia> livrosRequisitados;


    public JanelaRequisicoesDoSocio(List<LivroInstancia> livrosRequisitados) {
        this.livrosRequisitados = livrosRequisitados;

        setTitle("Lista de Requisições do Sócio");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.8);
        int height = (int) (screenSize.height * 0.8);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação do painel principal com layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(new JScrollPane(panel), BorderLayout.CENTER);

        // Adicionar título
        JLabel tituloLabel = new JLabel("Lista de livros Requisitados");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        // Espaço entre o título e a lista de sócios
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Adiciona um painel para cada sócio na lista
        for (LivroInstancia livroInstancia : livrosRequisitados) {
            JPanel socioPanel = new JPanel();
            socioPanel.setLayout(new BoxLayout(socioPanel, BoxLayout.X_AXIS));
            socioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            socioPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item

            JLabel nomeLabel = new JLabel(livroInstancia.getTitulo() + " #" + livroInstancia.getCodigoLivro() );
            nomeLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de nome
            socioPanel.add(nomeLabel);



            panel.add(socioPanel);

            // Espaço entre os itens da lista (muito pequeno)
            panel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        setVisible(true);
    }
}
