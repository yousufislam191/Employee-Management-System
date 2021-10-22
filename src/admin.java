import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class admin implements ActionListener {

    private JPanel body;
    private ImageIcon icon, logo;
    private JLabel logolabel, heading;

    private Font headingfont = new Font("Comic Sans MS", Font.BOLD, 40);
    private Font btnfont = new Font("Montserrat", Font.BOLD, 20);

    private JFrame f;
    private JButton b1,b2,b3;
    private JButton[] btn = new JButton[4];
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public admin()  {

        f = new JFrame("Employee Management System");
        f.setSize(500, 320);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        // icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0,500, 320);
        body.setBackground(new Color(244, 244, 244));
        body.setLayout(null);
        f.add(body);

        // logo add
        logo = new ImageIcon(getClass().getResource(".//image//R_logo.png"));
        logolabel = new JLabel(logo);
        logolabel.setBounds(30, 10, logo.getIconWidth(), logo.getIconHeight());
        body.add(logolabel);

        heading = new JLabel("Admin Dashboard");
        heading.setFont(headingfont);
        heading.setForeground(new Color(249, 163, 42));
        heading.setBounds(90, 12, 500, 45);
        body.add(heading);

        b1=new JButton("View Employee Details");
        b1.setBounds(110,80,260,40);
        b2=new JButton("Remove Employee");
        b2.setBounds(130,140,220,40);
        b3=new JButton("Update Employee");
        b3.setBounds(128,200,220,40);

        btn [0] = b1;
        btn [1] = b2;
        btn [2] = b3;

        for(int i=0; i<3; i++) {

            btn[i].setFont(new Font("serif",Font.BOLD,15));
            btn[i].addActionListener(this);
            btn[i].setBackground(new Color(244, 244, 244));
            btn[i].setForeground(new Color(41, 47, 69));
            btn[i].setCursor(cursor);
            btn[i].setFont(btnfont);
            btn[i].setBorder(null);
            body.add(btn[i]);
        }

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
 
        if(ae.getSource()==b1){ // new View_Employee();
            f.dispose();
            new adminViewSearch();
        }
        if(ae.getSource()==b2){ // new Remove_Employee();
            f.dispose();
            new searchRemove();
        }
        if(ae.getSource()==b3){ // new Search_Employee();
            f.dispose();
            new updateSearch();
        }
    }
}