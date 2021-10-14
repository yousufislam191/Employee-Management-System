import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame {

    private JPanel headerPanel;
    private JLabel heading;

    public Registration() {
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setResizable(false);
        setLayout(null);
        setVisible(true);

         //header panel add
         headerPanel = new JPanel();
         headerPanel.setBounds(0, 0, 400, 40);
         headerPanel.setBackground(new Color(0, 32, 63));
         
         heading = new JLabel("Registration Form");
         heading.setForeground(new Color(173, 239, 209));
         headerPanel.add(heading);
         add(headerPanel);
    }
}
