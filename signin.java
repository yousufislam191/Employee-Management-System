import javax.swing.*;
import java.awt.*;

public class signin extends JFrame {

    private JPanel headerPanel, body;
    private JLabel heading, email, pass;
    private JTextField headerTxt, userEmail, userPass;

    private JLabel[] label = new JLabel[2];
    private JTextField[] textFields = new JTextField[2];

    private JButton registerBtn, signinBtn;
    private JButton[] btn = new JButton[2];

    private Font font = new Font("Courier", Font.BOLD, 25);


    public signin () {

        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setResizable(false);
        setLayout(null);

        //header panel add
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 400, 50);
        headerPanel.setBackground(new Color(219,149,87));
        
        heading = new JLabel("I have an account");
        heading.setFont( font);
        headerPanel.add(heading);
        add(headerPanel);
        
        //body panel add
        body = new JPanel();
        body.setBounds(0, 50, 400, 500);
        body.setBackground(new Color(219,149,87));
        body.setLayout(null);
        add(body);

        //naming field
        email = new JLabel("Email : ");
        pass = new JLabel("Password : ");

        email.setBounds(50, 70, 100, 30);
        pass.setBounds(50, 160, 140, 30);

        label[0] = email;
        label[1] = pass;

        for(int i=0; i<2; i++) {
            // label[i].setFont(font);
            label[i].setForeground(Color.WHITE);
            body.add(label[i]);
        }

        //input field
        userEmail = new JTextField();
        userPass = new JTextField();

        userEmail.setBounds(50, 110, 250, 30);
        userPass.setBounds(50, 200, 250, 30);

        textFields[0] = userEmail;
        textFields[1] = userPass;

        for(int i=0; i<2; i++) {
            textFields[i].setBackground(Color.WHITE);
            textFields[i].setForeground(Color.BLACK);
            // textFields[i].setFont(bodyInputFont);
            body.add(textFields[i]);
        }

        //button add
        registerBtn = new JButton("Register");
        signinBtn = new JButton("Login");

        registerBtn.setBounds(80, 150, 150, 50);
        signinBtn.setBounds(420, 150, 100, 50);

        btn[0] = registerBtn;
        btn[1] = signinBtn;

        for(int i=0; i<2; i++) {
        btn[i].setBackground(new Color(219,149,87));
        btn[i].setForeground(Color.BLACK);
        // btn[i].setFont(headerFont);
        // btn[i].setBorder(new LineBorder(Color.white));
        body.add(btn[i]);
        }


        
        setVisible(true);
    }

    public static void main(String[] args) {
        new signin();
    }

}
