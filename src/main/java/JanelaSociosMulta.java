import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class JanelaSociosMulta extends JFrame {
    private JPanel panel;
    private JButton voltarButton;
    private JPanel panelSocios;


    public JanelaSociosMulta() {

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
        setTitle("Socios Com multa");
        //setLocationRelativeTo(null);

        //getContentPane().setBackground(new Color(40, 42, 67));
        panel.setBackground(new Color(40, 42, 67));

        List<Socio> sociosComMulta = Repositorio.getInstance().getSociosComMulta();

        int quantidade = sociosComMulta.size();
        if(quantidade != 0){
            panelSocios.setLayout(new GridLayout(quantidade,3));

            for (int i = 0; i < quantidade; i++) {
                JLabel label = new JLabel("Nº Socio: " + sociosComMulta.get(i).getNumeroSocio());
                panelSocios.add(label);
                label = new JLabel("Multa: " + sociosComMulta.get(i).getMulta());
                panelSocios.add(label);
                label = new JLabel("Nome: " + sociosComMulta.get(i).getNome());
                panelSocios.add(label);

            }
        }else{
            panelSocios.setLayout(new GridLayout(1,1));
            JLabel label = new JLabel("Nao Existe socios Com multa");
            panelSocios.add(label);
        }


        setVisible(true);
        voltarButton.addActionListener(this::btnVoltarActionPerformed);

    }

    private void btnVoltarActionPerformed(ActionEvent e) {

        this.dispose();
    }


}
