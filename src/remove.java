import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class remove extends JFrame {

    private JFrame f;
    private JPanel body;
    private JLabel heading, id1, id2, id3, t1, t2, t3;
    private JLabel[] vid = new JLabel[3];
    private JLabel[] t = new JLabel[3];
    private ImageIcon icon;
    private JButton btn1, btn2;
    private JButton[] btn = new JButton[2];
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    private ResultSet rs;
    private int flag = 0;
    private String viewid, viewfirstname, viewemail;

    private Font headingfont = new Font("Courier", Font.BOLD, 20);

    public remove(String adminremoveid) {

        f = new JFrame("Employee Management System");
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        // icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0, 500, 400);
        body.setBackground(new Color(250, 246, 240));
        body.setLayout(null);
        f.add(body);

        // get data from database
        DbConnect db = new DbConnect();
        try {
            rs = db.st.executeQuery(
                    "SELECT fastname, id, email FROM `employeeregistration` WHERE id='" + adminremoveid + "'");

            while (rs.next()) {
                viewid = rs.getString("id");
                viewfirstname = rs.getString("fastname");
                viewemail = rs.getString("email");

                flag = 1;
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" + e2);
        }

        heading = new JLabel("Remove Employee From Your Database");
        heading.setFont(headingfont);
        heading.setBounds(50, 10, 450, 30);
        heading.setForeground(Color.black);
        body.add(heading);

        id1 = new JLabel("Name :");
        id1.setBounds(100, 100, 100, 30);
        id2 = new JLabel("Id No :");
        id2.setBounds(100, 150, 100, 30);
        id3 = new JLabel("Email :");
        id3.setBounds(100, 200, 100, 30);

        vid[0] = id1;
        vid[1] = id2;
        vid[2] = id3;

        for (int i = 0; i < 3; i++) {
            vid[i].setFont(new Font("serif", Font.BOLD, 15));
            vid[i].setForeground(Color.BLACK);
            ;
            body.add(vid[i]);
        }

        t1 = new JLabel(viewfirstname);
        t2 = new JLabel(viewid);
        t3 = new JLabel(viewemail);

        t1.setBounds(160, 100, 200, 30);
        t2.setBounds(160, 150, 200, 30);
        t3.setBounds(160, 200, 200, 30);

        t[0] = t1;
        t[1] = t2;
        t[2] = t3;

        for (int i = 0; i < 3; i++) {
            t[i].setFont(new Font("serif", Font.BOLD, 15));
            t[i].setBackground(Color.WHITE);
            body.add(t[i]);
        }

        btn1 = new JButton("Remove");
        btn1.setBounds(200, 280, 80, 30);
        btn2 = new JButton("Back");
        btn2.setBounds(300, 280, 80, 30);

        btn[0] = btn1;
        btn[1] = btn2;

        for (int i = 0; i < 2; i++) {

            btn[i].setFont(new Font("serif", Font.BOLD, 15));
            btn[i].setBackground(Color.black);
            btn[i].setForeground(Color.WHITE);
            btn[i].setCursor(cursor);
            btn[i].setBorder(null);
            btn[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            body.add(btn[i]);
        }

        if (flag == 0) {
            JOptionPane.showMessageDialog(null, "This Id does not exist in database");
            f.dispose();
            new searchRemove();
        } else {
            f.setVisible(true);
        }

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // get data from database
                try {
                    db.st.executeUpdate("DELETE FROM `employeeregistration` WHERE id='" + adminremoveid + "'");
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                    f.dispose();
                    new searchRemove();
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" + e2);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new searchRemove();
            }
        });
    }
}
