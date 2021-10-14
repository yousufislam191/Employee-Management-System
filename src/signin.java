import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import javax.swing.border.*;
import java.util.regex.*;

public class signin extends JFrame {

    private JPanel headerPanel, body;
    private JLabel heading, email, pass, registertxt, ortxt, logolabel;
    private JTextField userEmail, userPass;
    private JButton signinBtn, registerBtn;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ImageIcon icon, logo;
    
    private JLabel[] label = new JLabel[2];
    private JTextField[] textFields = new JTextField[2];
    
    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);

    public signin () {

        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        //icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        setIconImage(icon.getImage());

        //header panel add
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 400, 40);
        headerPanel.setBackground(new Color(0, 32, 63));
        
        heading = new JLabel("Employee Management System");
        heading.setFont(headingfont);
        heading.setForeground(new Color(173, 239, 209));
        headerPanel.add(heading);
        add(headerPanel);
        
        //body panel add
        body = new JPanel();
        body.setBounds(0, 40, 400, 510);
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        add(body);

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
        userPass = new JTextField();

        userEmail.setBounds(50, 140, 290, 30);
        userPass.setBounds(50, 220, 290, 30);

        textFields[0] = userEmail;
        textFields[1] = userPass;

        for(int i=0; i<2; i++) {
            textFields[i].setBackground(Color.WHITE);
            textFields[i].setForeground(Color.BLACK);
            textFields[i].setFont(txtfont);
            body.add(textFields[i]);
        }

        //button add
        signinBtn = new JButton("Sign in");
        signinBtn.setBounds(50, 280, 290, 25);
        signinBtn.setBackground(new Color(173, 239, 209));
        signinBtn.setForeground(Color.BLACK);
        signinBtn.setCursor(cursor);
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
        ortxt.setBounds(50, 340, 300, 15);
        body.add(ortxt);

        
        setVisible(true);

        registerBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Registration();
            }
        });
        
        signinBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String signinUserEmail =  userEmail.getText();
                String signinUserPass = userPass.getText();
                String signinQuery = "SELECT * FROM `admin`";

                String emailRegex="[a-z0-9.]+@[a-z]+.[a-z]+$";
                String passRegex= "\\S+.{9,}$";

                if (!Pattern.matches(emailRegex,signinUserEmail)){
                    JOptionPane.showMessageDialog(null,"In-valid E-mail");
                }
                else if (!Pattern.matches(passRegex,signinUserPass)){
                    JOptionPane.showMessageDialog(null,"Your password must be 10 digits.");
                }
                else {
                    DbConnect db = new DbConnect();
                    db.Signin(signinQuery, signinUserEmail, signinUserPass);
                }
            }
        });
    }
}
