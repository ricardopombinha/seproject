import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaReservarLivroMensagem extends JFrame {
    private JPanel panel;
    private JButton voltarButton;
    private JLabel mensagemSucceso;

    public JanelaReservarLivroMensagem(String mensagem) {

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
        setTitle("Reservar Livro Mensagem");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));

        mensagemSucceso.setText(mensagem);

        // Set the frame to be visible
        setVisible(true);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);
    }

    private void btnVoltarActionPerformed(ActionEvent e) {
        this.dispose();

    }
}
