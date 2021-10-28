import java.sql.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class forgotPassSetp1 extends JFrame {

    private JFrame f;
    private JPanel body;
    private JLabel heading, ortxt, heading1;
    private ImageIcon icon;
    private JTextField forgotEmail;
    private JButton btn1, btn2;
    private String viewemail, getemail = " ";
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ResultSet rs;
    private int flag = 0;

    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);

    public forgotPassSetp1() {

        f = new JFrame("Employee Management System");
        f.setSize(500, 270);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        // icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0, 500, 270);
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        f.add(body);

        heading1 = new JLabel("Recovery Password");
        heading1.setFont(headingfont);
        heading1.setBounds(150, 10, 200, 30);
        heading1.setForeground(new Color(173, 239, 209));
        body.add(heading1);

        heading = new JLabel("Enter your email:");
        heading.setFont(txtfont);
        heading.setBounds(50, 50, 450, 30);
        heading.setForeground(new Color(173, 239, 209));
        body.add(heading);

        forgotEmail = new JTextField();
        forgotEmail.setBounds(50, 80, 380, 30);
        forgotEmail.setBackground(new Color(225, 229, 232));
        forgotEmail.setForeground(Color.BLACK);
        forgotEmail.setFont(txtfont);
        forgotEmail.setBorder(null);
        body.add(forgotEmail);

        btn1 = new JButton("Next");
        btn1.setBounds(50, 130, 380, 20);
        btn1.setBackground(new Color(173, 239, 209));
        btn1.setForeground(Color.BLACK);
        btn1.setCursor(cursor);
        btn1.setFont(txtfont);
        btn1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(btn1);

        ortxt = new JLabel("--------------------------------------------- Or --------------------------------------------");
        ortxt.setForeground(Color.WHITE);
        ortxt.setFont(txtfont);
        ortxt.setBounds(50, 160, 380, 15);
        body.add(ortxt);

        btn2 = new JButton("Sign in");
        btn2.setBounds(220, 180, 45, 20);
        btn2.setForeground(new Color(173, 239, 209));
        btn2.setBackground(new Color(0, 32, 63));
        btn2.setBorder(null);
        btn2.setCursor(cursor);
        btn2.setFont(txtfont);
        body.add(btn2);
        
        f.setVisible(true);

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new signin();
            }
        });

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String forgotUserEmail = forgotEmail.getText();

                String emailRegex = "[a-z0-9.]+@[a-z]+[.[a-z]]+$";

                if (!Pattern.matches(emailRegex, forgotUserEmail)) {
                    JOptionPane.showMessageDialog(null, "In-valid E-mail");
                }
                else {
                    DbConnect db = new DbConnect();
                    try {
                        rs = db.st.executeQuery("SELECT email FROM `employeeregistration` WHERE email='" + forgotUserEmail + "'");

                        while (rs.next()) {
                            viewemail = rs.getString("email");
                            getemail = viewemail;
                            flag = 1;
                        }
                    }catch(Exception e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                    if(flag == 0) {
                        JOptionPane.showMessageDialog(null, "This Id does not exist in database");
                    }
                    else {
                        f.dispose();
                        new forgotPassSetp2(getemail);
                    }
                }
            }
        });
    }  
}
