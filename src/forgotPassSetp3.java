import java.sql.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class forgotPassSetp3 extends JFrame {
     
    private JFrame f;
    private JPanel body;
    private JLabel forgotName, forgotPhone, heading1;
    private ImageIcon icon;
    private JPasswordField forgotNameTxt, forgotPhoneTxt;
    private JButton btn1;
    private JCheckBox checkBox;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    
    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);

    public forgotPassSetp3(String getemail) {

        f = new JFrame("Employee Management System");
        f.setSize(500, 300);
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

        forgotName = new JLabel("Enter your new password: ");
        forgotName.setFont(txtfont);
        forgotName.setBounds(50, 50, 450, 30);
        forgotName.setForeground(new Color(173, 239, 209));
        body.add(forgotName);

        forgotNameTxt = new JPasswordField();
        forgotNameTxt.setBounds(50, 75, 380, 25);
        forgotNameTxt.setBackground(new Color(225, 229, 232));
        forgotNameTxt.setForeground(Color.BLACK);
        forgotNameTxt.setFont(txtfont);
        forgotNameTxt.setBorder(null);
        body.add(forgotNameTxt);

        forgotPhone = new JLabel("Re-type password:");
        forgotPhone.setFont(txtfont);
        forgotPhone.setBounds(50, 110, 450, 30);
        forgotPhone.setForeground(new Color(173, 239, 209));
        body.add(forgotPhone);

        forgotPhoneTxt = new JPasswordField();
        forgotPhoneTxt.setBounds(50, 135, 380, 25);
        forgotPhoneTxt.setBackground(new Color(225, 229, 232));
        forgotPhoneTxt.setForeground(Color.BLACK);
        forgotPhoneTxt.setFont(txtfont);
        forgotPhoneTxt.setBorder(null);
        body.add(forgotPhoneTxt);

        // checkbox add
        checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(50, 170, 120, 15);
        checkBox.setBackground(null);
        checkBox.setForeground(new Color(173, 239, 209));
        checkBox.setBorder(null);
        body.add(checkBox);

        btn1 = new JButton("Update Password");
        btn1.setBounds(50, 200, 390, 25);
        btn1.setBackground(new Color(173, 239, 209));
        btn1.setForeground(Color.BLACK);
        btn1.setCursor(cursor);
        btn1.setFont(txtfont);
        btn1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(btn1);

        f.setVisible(true);

        checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    forgotNameTxt.setEchoChar((char) 0);
                    forgotPhoneTxt.setEchoChar((char) 0);
                } else {
                    forgotNameTxt.setEchoChar('\u25CF');
                    forgotPhoneTxt.setEchoChar('\u25CF');
                }
            }
        });

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String forgotUserName = forgotNameTxt.getText();
                String forgotUserPhone = forgotPhoneTxt.getText();

                String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}$";

                // condition
                if (!forgotUserName.equals(forgotUserPhone)) {
                    JOptionPane.showConfirmDialog(null, "Password & confirm password is not matching");
                }

                else if (!Pattern.matches(passRegex, forgotUserName)) {
                    JOptionPane.showMessageDialog(null, "Your password is not secure. Please set a strong password \r\n"
                            + "with 10 digits using uppercase, lowercase and special character");
                }
                else {
                    DbConnect db = new DbConnect();
                    try {
                        String queryInsert ="UPDATE `employeeregistration` SET `password`='"+forgotNameTxt.getText()+"' WHERE email='" +getemail+ "'";
                        db.st.executeUpdate(queryInsert);
                        JOptionPane.showMessageDialog(null, "Your Password Update Successfully");
                        f.dispose();

                    }catch(Exception e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }
        });
    }
}
