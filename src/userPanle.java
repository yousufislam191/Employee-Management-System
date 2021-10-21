import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.border.*;

public class userPanle extends JFrame {

    private JPanel body;
    private JLabel addImageLabel, addNameLabel, designationeLabel, idLabel, getidLabel, contactLabel, getcontactLabel, emailLabel, getemailLabel, dobLabel, getdobLabel, bloodgroupLabel, getbloodgroupLabel, getgenderLabel, paddressLabel, getpaddressLabel, caddressLabel, getcaddressLabel;
    private ImageIcon icon;

    /*font name: Times New Roman, Sagor UI, Arial, Comfortaa, Montserrat, Trebuchet MS, Roboto, Verdana, Comic Sans MS*/
    private Font headingfont = new Font("Comic Sans MS", Font.BOLD, 35);
    private Font subheadingfont = new Font("Montserrat", Font.BOLD, 23);
    private Font suppersubheadingfont = new Font("Verdana",Font.LAYOUT_LEFT_TO_RIGHT, 15);
    private Font font = new Font("Trebuchet MS",Font.CENTER_BASELINE, 18);

    private ResultSet rs;
    public String viewid, viewfirstname, viewdesignation, viewdob, viewcontact, viewimage, viewbloodgroup, viewgender, viewemail, viewpassword, viewPaddress, viewCaddress;

    public userPanle(String signinUserEmail)  {

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
        body.setBackground(new Color(250, 246, 240));
        body.setLayout(null);
        add(body);

        //get data from database
        DbConnect db = new DbConnect();
        try {
            rs = db.st.executeQuery("SELECT * FROM `employeeregistration` WHERE email='"+signinUserEmail+"'");
            
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
            }
        }
        catch(Exception e2) {
            JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" +e2);
        }

        //add field
        addImageLabel = new JLabel();
        addImageLabel.setBounds(80, 50, 200, 200);
        addImageLabel.setBorder(BorderFactory.createLineBorder(new Color(173, 239, 209)));
        body.add(addImageLabel);

        addNameLabel = new JLabel(viewfirstname);
        addNameLabel.setBounds(320, 60, 500, 50);
        addNameLabel.setFont(headingfont);
        body.add(addNameLabel);

        designationeLabel = new JLabel(viewdesignation);
        designationeLabel.setBounds(320, 100, 400, 50);
        designationeLabel.setFont(subheadingfont);
        body.add(designationeLabel);

        idLabel = new JLabel("Id no :");
        idLabel.setBounds(320, 140, 100, 50);
        idLabel.setFont(suppersubheadingfont);
        body.add(idLabel);

        getidLabel = new JLabel(viewid);
        getidLabel.setBounds(380, 140, 100, 50);
        getidLabel.setFont(suppersubheadingfont);
        body.add(getidLabel);

        bloodgroupLabel = new JLabel("Blood Group :");
        bloodgroupLabel.setBounds(320, 170, 130, 50);
        bloodgroupLabel.setFont(suppersubheadingfont);
        body.add(bloodgroupLabel);

        getbloodgroupLabel = new JLabel(viewbloodgroup);
        getbloodgroupLabel.setBounds(440, 170, 100, 50);
        getbloodgroupLabel.setFont(suppersubheadingfont);
        body.add(getbloodgroupLabel);

        getgenderLabel = new JLabel(viewgender);
        getgenderLabel.setBounds(320, 200, 100, 50);
        getgenderLabel.setFont(suppersubheadingfont);
        body.add(getgenderLabel);

        contactLabel = new JLabel("Contact");
        contactLabel.setBounds(80, 280, 100, 50);
        contactLabel.setFont(font);
        body.add(contactLabel);

        getcontactLabel = new JLabel(viewcontact);
        getcontactLabel.setBounds(80, 300, 200, 50);
        getcontactLabel.setFont(suppersubheadingfont);
        body.add(getcontactLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(340, 280, 100, 50);
        emailLabel.setFont(font);
        body.add(emailLabel);

        getemailLabel = new JLabel(viewemail);
        getemailLabel.setBounds(340, 300, 230, 50);
        getemailLabel.setFont(suppersubheadingfont);
        body.add(getemailLabel);

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(600, 280, 150, 50);
        dobLabel.setFont(font);
        body.add(dobLabel);

        getdobLabel = new JLabel(viewdob);
        getdobLabel.setBounds(600, 300, 100, 50);
        getdobLabel.setFont(suppersubheadingfont);
        body.add(getdobLabel);

        paddressLabel = new JLabel("Parmanent Address : ");
        paddressLabel.setBounds(80, 360, 200, 50);
        paddressLabel.setFont(font);
        body.add(paddressLabel);

        getpaddressLabel = new JLabel(viewPaddress);
        getpaddressLabel.setBounds(280, 370, 500, 30);
        getpaddressLabel.setFont(suppersubheadingfont);
        getpaddressLabel.setBorder(BorderFactory.createLineBorder(new Color(173, 239, 209)));
        body.add(getpaddressLabel);

        caddressLabel = new JLabel("Current Address      : ");
        caddressLabel.setBounds(80, 400, 200, 50);
        caddressLabel.setFont(font);
        body.add(caddressLabel);

        getcaddressLabel = new JLabel(viewCaddress);
        getcaddressLabel.setBounds(280, 410, 500, 30);
        getcaddressLabel.setFont(suppersubheadingfont);
        getcaddressLabel.setBorder(BorderFactory.createLineBorder(new Color(173, 239, 209)));
        body.add(getcaddressLabel);


        setVisible(true);
    } 
}
