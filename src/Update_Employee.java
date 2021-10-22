import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
class Update_Employee extends JFrame{
 
    private JFrame f;
    private JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15,id16,id17,lab,lab1;
    private JLabel[] vid = new JLabel[15];
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    private JTextField[] t = new JTextField[15];
    private JButton b,b1;
    private ImageIcon icon;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    private int flag = 0;
    private ResultSet rs;
    public String viewid, viewfirstname, viewdesignation, viewdob, viewcontact, viewimage, viewbloodgroup, viewgender, viewemail, viewpassword, viewPaddress, viewCaddress, viewJoiningDate, viewPosition, viewSalary, viewDuityTime, viewBranch;
   
    Update_Employee(String id){

        //design part
        f = new JFrame("Employee Management System");
        f.setBackground(Color.white);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(900,700);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setBackground(new Color(0, 32, 63));
        id15.setLayout(null);

        //icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        //get data from database
        DbConnect db = new DbConnect();
        try {
            rs = db.st.executeQuery("SELECT * FROM `employeeregistration` WHERE id='"+id+"'");
            
            while(rs.next()) {
                viewid = rs.getString("id");
                viewfirstname = rs.getString("fastname");	
                viewdesignation = rs.getString("designation");
                viewdob = rs.getString("dob");
                viewcontact = rs.getString("contact");
                viewimage = rs.getString("image");
                viewbloodgroup = rs.getString("bloodgroup");
                viewgender = rs.getString("gender");
                viewemail = rs.getString("email");
                viewPaddress = rs.getString("Paddress");
                viewCaddress = rs.getString("Caddress");
                viewJoiningDate = rs.getString("joiningdate");
                viewPosition = rs.getString("position");
                viewSalary = rs.getString("salary");
                viewDuityTime = rs.getString("duitytime");
                viewBranch = rs.getString("branch");

                flag = 1;
            }
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" +e2);
        }

        id8 = new JLabel("Update Employee Details");
        id8.setBounds(320,20,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("Name");
        id1.setBounds(50,100,100,30);
        id2 = new JLabel("Designation");
        id2.setBounds(460,100,200,30);
        id3= new JLabel("Blood Group"); 
        id3.setBounds(50,150,100,30);
        id4= new JLabel("Date Of Birth");  
        id4.setBounds(460,150,200,30);
        id5= new JLabel("Gender");
        id5.setBounds(50,200,100,30);
        id6= new JLabel("Phone");
        id6.setBounds(460,200,100,30);
        id7= new JLabel("Email");
        id7.setBounds(50,250,100,30);
        id9= new JLabel("Joining Date");
        id9.setBounds(460,250,100,30);
        id10= new JLabel("Position");
        id10.setBounds(50,300,100,30);
        id11= new JLabel("Salary");
        id11.setBounds(460,300,100,30);
        id12= new JLabel("Employee Id");
        id12.setBounds(50,350,150,30);
        id13= new JLabel("Duity Time");
        id13.setBounds(460,350,100,30);
        id14= new JLabel("Branch");
        id14.setBounds(50,400,150,30);
        id16= new JLabel("Parmanent Address");
        id16.setBounds(50,450,130,30);
        id17= new JLabel("Current Address");
        id17.setBounds(50,500,150,30);

        vid[0] = id1;
        vid[1] = id2;
        vid[2] = id3;
        vid[3] = id4;
        vid[4] = id5;
        vid[5] = id6;
        vid[6] = id7;
        vid[7] = id9;
        vid[8] = id10;
        vid[9] = id11;
        vid[10] = id12;
        vid[11] = id13;
        vid[12] = id14;
        vid[13] = id16;
        vid[14] = id17;

        for(int i=0; i<15; i++) {
            vid[i].setFont(new Font("serif",Font.BOLD,15));
            id15.add(vid[i]);
        }

        t1 = new JTextField(viewfirstname);
        t2 = new JTextField(viewdesignation);
        t3 = new JTextField(viewbloodgroup);
        t4 = new JTextField(viewdob);
        t5 = new JTextField(viewgender);
        t6 = new JTextField(viewcontact);
        t7 = new JTextField(viewemail);
        t8 = new JTextField(viewJoiningDate);
        t9 = new JTextField(viewPosition);
        t10 = new JTextField(viewSalary);
        t11 = new JTextField(viewid);
        t12 = new JTextField(viewDuityTime);
        t13 = new JTextField(viewBranch);
        t14 = new JTextField(viewPaddress);
        t15 = new JTextField(viewCaddress);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t11.setEditable(false);
        t14.setEditable(false);
        t15.setEditable(false);

        t1.setBounds(200,100,200,30);
        t2.setBounds(600,100,200,30);
        t3.setBounds(200,150,200,30);
        t4.setBounds(600,150,200,30);
        t5.setBounds(200,200,200,30);
        t6.setBounds(600,200,200,30);
        t7.setBounds(200,250,200,30);
        t8.setBounds(600,250,200,30);
        t9.setBounds(200,300,200,30);
        t10.setBounds(600,300,200,30);
        t11.setBounds(200,350,200,30);
        t12.setBounds(600,350,200,30);
        t13.setBounds(200,400,200,30);
        t14.setBounds(200,450,620,30);
        t15.setBounds(200,500,620,30);

        t[0] = t1;
        t[1] = t2;
        t[2] = t3;
        t[3] = t4;
        t[4] = t5;
        t[5] = t6;
        t[6] = t7;
        t[7] = t8;
        t[8] = t9;
        t[9] = t10;
        t[10] = t11;
        t[11] = t12;
        t[12] = t13;
        t[13] = t14;
        t[14] = t15;

        for(int i=0; i<15; i++) {
            t[i].setFont(new Font("serif",Font.BOLD,15));
            t[i].setBackground(Color.WHITE);
            id15.add(t[i]);
        }

        b = new JButton("Update");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("serif",Font.BOLD,18));
        b.setCursor(cursor);
        b.setBounds(250,580,150,40);
        id15.add(b);

        b1=new JButton("Cancel");  
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("serif",Font.BOLD,18));
        b1.setCursor(cursor);
        b1.setBounds(480,580,150,40);
        id15.add(b1);

        if(flag == 0) {
            JOptionPane.showMessageDialog(null, "This Id does not exist in database");
            f.dispose();
            new updateSearch(); 
        }
        else {
            f.setVisible(true);
        }

        b.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    DbConnect db = new DbConnect();
                    String queryInsert = "UPDATE `employeeregistration` SET `joiningdate`='"+t8.getText()+"',`position`='"+t9.getText()+"',`salary`='"+t10.getText()+"',`duitytime`='"+t12.getText()+"',`branch`='"+t13.getText()+"' WHERE id='"+id+"'";
                    db.st.executeUpdate(queryInsert);
                    JOptionPane.showMessageDialog(null, "Update Successfully");
                    f.dispose();
                    new admin();
                } 
                catch (Exception e3) {
                    JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" +e3);
                }
            }
        });

        b1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            f.dispose();
            new admin();    
            
            }
        });
    }
}