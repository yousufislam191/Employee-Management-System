import java.sql.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class forgotPassSetp2 extends JFrame {
    
    private JFrame f;
    private JPanel body;
    private JLabel forgotName, forgotPhone, heading1;
    private ImageIcon icon;
    private JTextField forgotNameTxt, forgotPhoneTxt;
    private JButton btn1, btn2;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ResultSet rs;
    private int flag = 0;

    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);

    public forgotPassSetp2(String getemail) {
        
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

        forgotName = new JLabel("Enter your name:");
        forgotName.setFont(txtfont);
        forgotName.setBounds(50, 50, 450, 30);
        forgotName.setForeground(new Color(173, 239, 209));
        body.add(forgotName);

        forgotNameTxt = new JTextField();
        forgotNameTxt.setBounds(50, 75, 380, 25);
        forgotNameTxt.setBackground(new Color(225, 229, 232));
        forgotNameTxt.setForeground(Color.BLACK);
        forgotNameTxt.setFont(txtfont);
        forgotNameTxt.setBorder(null);
        body.add(forgotNameTxt);

        forgotPhone = new JLabel("Enter your phone number:");
        forgotPhone.setFont(txtfont);
        forgotPhone.setBounds(50, 110, 450, 30);
        forgotPhone.setForeground(new Color(173, 239, 209));
        body.add(forgotPhone);

        forgotPhoneTxt = new JTextField();
        forgotPhoneTxt.setBounds(50, 135, 380, 25);
        forgotPhoneTxt.setBackground(new Color(225, 229, 232));
        forgotPhoneTxt.setForeground(Color.BLACK);
        forgotPhoneTxt.setFont(txtfont);
        forgotPhoneTxt.setBorder(null);
        body.add(forgotPhoneTxt);

        btn1 = new JButton("Next");
        btn1.setBounds(270, 180, 70, 25);
        btn1.setBackground(new Color(173, 239, 209));
        btn1.setForeground(Color.BLACK);
        btn1.setCursor(cursor);
        btn1.setFont(txtfont);
        btn1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(btn1);

        btn2 = new JButton("Cancel");
        btn2.setBounds(140, 180, 70, 25);
        btn2.setBackground(new Color(173, 239, 209));
        btn2.setForeground(Color.BLACK);
        btn2.setCursor(cursor);
        btn2.setFont(txtfont);
        btn2.setBorder(BorderFactory.createLineBorder(Color.WHITE));;
        body.add(btn2);
        
        f.setVisible(true);

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String forgotUserName = forgotNameTxt.getText();
                String forgotUserPhone = forgotPhoneTxt.getText();

                String nameRegex = "^[a-zA-Z. ]+$";
                String mobileRegex = "(\\+88)?01[3-9]\\d{8}";

                // condition
                if (!Pattern.matches(nameRegex, forgotUserName)) {
                    JOptionPane.showMessageDialog(null, "In-valid First Name");
                }
                else if (!Pattern.matches(mobileRegex, forgotUserPhone)) {
                    JOptionPane.showMessageDialog(null, "In-valid Phone Number");
                }
                else {
                    DbConnect db = new DbConnect();
                    try {
                        rs = db.st.executeQuery("SELECT `fastname`,`contact` FROM `employeeregistration` WHERE email ='" + getemail + "' and fastname = '"+forgotUserName+"' and contact = '"+forgotUserPhone+"'");

                        while (rs.next()) {
                            String viewname = rs.getString("fastname");
                            String viewphone = rs.getString("contact");
            
                            flag = 1;
                        }
                    }catch(Exception e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                    if(flag == 0) {
                        JOptionPane.showMessageDialog(null, "                   The name and phone number with your email were not found in the database. \r\n"
                        +"Please enter your correct Name & Phone Number which you provided when you registered with this email.");
                    }
                    else {
                        f.dispose();
                        new forgotPassSetp3(getemail);
                    }
                }
            }
        });

    }
}
