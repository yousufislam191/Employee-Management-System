import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class admin extends JFrame implements ActionListener {

    private JPanel body;
    private ImageIcon icon, logo;
    private JLabel logolabel, heading;

    private Font headingfont = new Font("Courier", Font.BOLD, 35);

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4;

    public admin()  {

        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0, 900, 700);
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        add(body);

        // logo add
        logo = new ImageIcon(getClass().getResource(".//image//R_logo.png"));
        logolabel = new JLabel(logo);
        logolabel.setBounds(30, 10, logo.getIconWidth(), logo.getIconHeight());
        body.add(logolabel);

        heading = new JLabel("Employee Details");
        heading.setFont(headingfont);
        heading.setForeground(new Color(173, 239, 209));
        heading.setBounds(100, 12, 500, 45);
        body.add(heading);



        b1=new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        body.add(b1);


        b2=new JButton("View");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        body.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        body.add(b3);

        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        body.add(b4);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            // new Add_Employee();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            // new View_Employee();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            // new Remove_Employee();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            // new Search_Employee();
        }
    }
    // public static void main(String[] args) {
    //     new admin();
    // }
    
}
