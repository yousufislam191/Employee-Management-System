import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class admin extends JFrame implements ActionListener {

    // private JPanel headerPanel;
    // private JLabel heading;

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4;

    public admin()  {

        // setSize(400, 550);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
        // // setResizable(false);
        // setLayout(null);
        // setVisible(true);

        // //header panel add
        // headerPanel = new JPanel();
        // headerPanel.setBounds(0, 0, 400, 40);
        // headerPanel.setBackground(new Color(0, 32, 63));
        
        // heading = new JLabel("admin panel");
        // heading.setForeground(new Color(173, 239, 209));
        // headerPanel.add(heading);
        // add(headerPanel);


        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/details.jpg"));
        // l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("Employee Details");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
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
    
}
