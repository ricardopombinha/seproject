import models.LivroInstancia;
import models.Requisicao;
import models.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaHistoricoDeLivrosRequisitados extends JFrame {

    private List<Requisicao> historicoLivrosRequisitados;


    public JanelaHistoricoDeLivrosRequisitados(List<Requisicao> historicoLivrosRequisitados) {
        this.historicoLivrosRequisitados = historicoLivrosRequisitados;

        setTitle("Lista de Requisições do Sócio de todo o tempo");
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
        JLabel tituloLabel = new JLabel("Lista de livros Requisitados do Sócio de todo o tempo");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        // Espaço entre o título e a lista de sócios
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Adiciona um painel para cada sócio na lista
        for (Requisicao requisicao : historicoLivrosRequisitados) {
            JPanel socioPanel = new JPanel();
            socioPanel.setLayout(new BoxLayout(socioPanel, BoxLayout.X_AXIS));
            socioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            socioPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item

            JLabel nomeLabel = new JLabel(requisicao.getLivroInstancia().getTitulo() + "  Código: #" + requisicao.getLivroInstancia().getCodigoLivro() + "      No dia: " + requisicao.getDataEmprestimo());
            nomeLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de nome
            socioPanel.add(nomeLabel);



            panel.add(socioPanel);

            // Espaço entre os itens da lista (muito pequeno)
            panel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        setVisible(true);
    }
}