import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class updateSearch extends JFrame {

    private JFrame f;
    private JPanel body;
    private JLabel heading, msg;
    private ImageIcon icon;
    private JTextField searchid;
    private JButton btn1, btn2;
    private JButton[] btn = new JButton[2];
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    private Font headingfont = new Font("Courier", Font.BOLD, 20);
    private Font msgfont = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 15);

    public updateSearch () {

        f = new JFrame("Employee Management System");
        f.setSize(500, 270);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        //icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0, 500, 270);
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        f.add(body);

        heading = new JLabel("Find Employee Details");
        heading.setFont(headingfont);
        heading.setBounds(130, 10, 450, 30);
        heading.setForeground(new Color(173, 239, 209));
        body.add(heading);

        msg = new JLabel("Enter Employee Id :");
        msg.setFont(msgfont);
        msg.setBounds(50, 80, 200, 30);
        msg.setForeground(Color.WHITE);
        body.add(msg);

        searchid = new JTextField();
        searchid.setFont(msgfont);
        searchid.setBounds(220, 80, 200, 30);
        searchid.setBackground(Color.WHITE);
        searchid.setForeground(Color.BLACK);
        searchid.setBorder(null);
        body.add(searchid);

        btn1=new JButton("Search");
        btn1.setBounds(240,150,80,30);
        btn2=new JButton("Back");
        btn2.setBounds(340,150,80,30);

        btn [0] = btn1;
        btn [1] = btn2;

        for(int i=0; i<2; i++) {

            btn[i].setFont(new Font("serif",Font.BOLD,18));
            btn[i].setBackground(new Color(173, 239, 209));
            btn[i].setForeground(new Color(41, 47, 69));
            btn[i].setCursor(cursor);
            btn[i].setBorder(null);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            body.add(btn[i]);
        }


        f.setVisible(true);

        btn1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = searchid.getText();
                String idregex= "[0-9]+";

                if (!Pattern.matches(idregex,id)) {
                    JOptionPane.showMessageDialog(null,"In-valid id");
                }
                else {
                    f.dispose();
                    new Update_Employee(searchid.getText());
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new admin();
            }
        });
    }
}
