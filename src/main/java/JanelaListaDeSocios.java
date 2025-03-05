import models.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JanelaListaDeSocios extends JFrame {

    private List<Socio> socios;
    private JPanel panel1;

    public JanelaListaDeSocios(List<Socio> sociosEncontrados, String nome) {
        this.socios = sociosEncontrados;
        setTitle("Lista de Sócios");
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
        JLabel tituloLabel = new JLabel("Lista de Sócios com nome " + nome);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tituloLabel);
        tituloLabel.setForeground(new Color(255,255,255));

        // Espaço entre o título e a lista de sócios
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.setBackground(new Color(40,42,67));

        // Adiciona um painel para cada sócio na lista
        for (Socio socio : sociosEncontrados) {
            JPanel socioPanel = new JPanel();
            socioPanel.setLayout(new BoxLayout(socioPanel, BoxLayout.X_AXIS));
            socioPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            socioPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Limite pequeno para cada item

            JLabel nomeLabel = new JLabel(socio.getNome());
            nomeLabel.setPreferredSize(new Dimension(200, 20)); // Ajuste do tamanho do label de nome
            socioPanel.add(nomeLabel);
            nomeLabel.setForeground(new Color(255,255,255));

            socioPanel.add(Box.createHorizontalGlue()); // Adiciona espaço flexível entre o nome e o botão

            JButton selecionarButton = new JButton("Selecionar");
            selecionarButton.setPreferredSize(new Dimension(100, 20)); // Ajuste do tamanho do botão
            selecionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //JOptionPane.showMessageDialog(JanelaListaDeSocios.this, "Sócio selecionado: " + socio.getNome());
                    new JanelaDetalhesSocio(socio);
                    dispose();
                }

            });
            socioPanel.add(selecionarButton);

            panel.add(socioPanel);
            socioPanel.setBackground(new Color(40,42,67));

            // Espaço entre os itens da lista (muito pequeno)
            panel.add(Box.createRigidArea(new Dimension(0, 2)));
        }

        setVisible(true);
    }

}