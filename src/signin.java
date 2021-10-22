import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.regex.*;

public class signin extends JFrame {

    private JFrame f;
    private JPanel headerPanel, body;
    private JLabel heading, email, pass, registertxt, ortxt, logolabel;
    private JTextField userEmail;
    private JButton signinBtn, registerBtn;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon, logo;
    private JCheckBox checkBox;
    private JPasswordField userPass;
    
    private JLabel[] label = new JLabel[2];
    
    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);

    private ResultSet rs;
    private int flag = 0;

    public signin () {

        f = new JFrame("Employee Management System");
        f.setSize(400, 550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        //icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        //header panel add
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 400, 40);
        headerPanel.setBackground(new Color(0, 32, 63));
        
        heading = new JLabel("Employee Management System");
        heading.setFont(headingfont);
        heading.setForeground(new Color(173, 239, 209));
        headerPanel.add(heading);
        f.add(headerPanel);
        
        //body panel add
        body = new JPanel();
        body.setBounds(0, 40, 400, 510);
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        f.add(body);

        //logo add
        logo = new ImageIcon(getClass().getResource(".//image//logo.png"));
        logolabel = new JLabel(logo);
        logolabel.setBounds(160, 10, logo.getIconWidth(), logo.getIconHeight());
        body.add(logolabel);

        //naming label field
        email = new JLabel("Email : ");
        pass = new JLabel("Password : ");

        email.setBounds(50, 110, 100, 30);
        pass.setBounds(50, 190, 140, 30);

        label[0] = email;
        label[1] = pass;

        for(int i=0; i<2; i++) {
            label[i].setFont(txtfont);
            label[i].setForeground(Color.WHITE);
            body.add(label[i]);
        }

        //input field
        userEmail = new JTextField();
        userEmail.setBounds(50, 140, 290, 30);
        userEmail.setBackground(Color.WHITE);
        userEmail.setForeground(Color.BLACK);
        userEmail.setFont(txtfont);
        userEmail.setBorder(null);
        body.add(userEmail);

        userPass = new JPasswordField();
        userPass.setBounds(50, 220, 290, 30);
        userPass.setBackground(Color.WHITE);
        userPass.setForeground(Color.BLACK);
        userPass.setFont(txtfont);
        userPass.setBorder(null);
        body.add(userPass);

        //checkbox add
        checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(50, 260, 120, 15);
        checkBox.setBackground(null);
        checkBox.setForeground(new Color(173, 239, 209));
        checkBox.setBorder(null);
        body.add(checkBox);

        //button add
        signinBtn = new JButton("Sign in");
        signinBtn.setBounds(50, 300, 290, 25);
        signinBtn.setBackground(new Color(173, 239, 209));
        signinBtn.setForeground(Color.BLACK);
        signinBtn.setCursor(cursor);
        signinBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(signinBtn);

        registerBtn = new JButton("Register now");
        registerBtn.setForeground(new Color(173, 239, 209));
        registerBtn.setBackground(new Color(0, 32, 63));
        registerBtn.setBorder(null);
        registerBtn.setBounds(216, 370, 75, 15);
        registerBtn.setCursor(cursor);
        body.add(registerBtn);

        //naming label add
        registertxt = new JLabel("Not registered yet?");
        registertxt.setForeground(Color.WHITE);
        registertxt.setBounds(98, 370, 110, 15);
        body.add(registertxt);

        ortxt = new JLabel("---------------------------------- Or ---------------------------------");
        ortxt.setForeground(Color.WHITE);
        ortxt.setFont(txtfont);
        ortxt.setBounds(50, 350, 300, 15);
        body.add(ortxt);

        
        f.setVisible(true);
        
        checkBox.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

               if(checkBox.isSelected()) {
                    userPass.setEchoChar((char)0);
               }
               else {
                   userPass.setEchoChar('\u25CF');
               }
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Registration();
            }
        });
        
        signinBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String signinUserEmail =  userEmail.getText();
                String signinUserPass = userPass.getText();
                String signinQuery = "SELECT * FROM `employeeregistration`";

                String emailRegex="[a-z0-9.]+@[a-z]+[.[a-z]]+$";
                String passRegex= "\\S+.{9,}$";

                if (!Pattern.matches(emailRegex,signinUserEmail)){
                    JOptionPane.showMessageDialog(null,"In-valid E-mail");
                }
                else if (!Pattern.matches(passRegex,signinUserPass)){
                    JOptionPane.showMessageDialog(null,"Your password must be 10 digits.");
                }
                else {
                    //for login query
                    try {
                        //admin email & pass 
                        String adminemail = "admin.employeems@gmail.com";
                        String adminpass = "@dm21InEMS#";
            
                        DbConnect db = new DbConnect();

                        rs = db.st.executeQuery("select * from employeeregistration");
                        rs = db.st.executeQuery(signinQuery);
                        while(rs.next()) {
                            String tableUserEmail = rs.getString(9);
                            String tablePass = rs.getString(10);
            
                            if (signinUserEmail.equals(tableUserEmail) && signinUserPass.equals(tablePass)) {
                                flag = 1;
                                break;
                            }
                        }
                        if(signinUserEmail.equals(adminemail) && signinUserPass.equals(adminpass)) {
                            JOptionPane.showMessageDialog(null, "Successfully Admin Panel login");
                            f.dispose();
                            new admin();
                        }
                        else if(flag == 0) {
                            JOptionPane.showMessageDialog(null, "wrong username & password");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Successfully User login");
                            f.dispose();
                            new userPanle(userEmail.getText());
                        }
                    }
                    catch (Exception e2) {
                        System.err.println("Login Error :"+e2);
                    }
                }
            }
        });
    }
}
