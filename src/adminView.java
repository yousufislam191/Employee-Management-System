import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class adminView extends JFrame {

    private JFrame f;
    private JPanel body;
    private JLabel addImageLabel, addNameLabel, designationeLabel, idLabel, getidLabel, contactLabel, getcontactLabel,
            emailLabel, getemailLabel, dobLabel, getdobLabel, bloodgroupLabel, getbloodgroupLabel, getgenderLabel,
            paddressLabel, getpaddressLabel, caddressLabel, getcaddressLabel, joinDateLabel, getjoinDateLabel,
            positionLabel, getpositionLabel, salaryLabel, getsalaryLabel, duityTimeLabel, getduityTimeLabel,
            branchLabel, getbranchLabel;
    private ImageIcon icon, getimg, setimg;
    private JButton close;
    private int flag = 0;
    private byte[] b;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    /*
     * font name: Times New Roman, Sagor UI, Arial, Comfortaa, Montserrat, Trebuchet
     * MS, Roboto, Verdana, Comic Sans MS
     */
    private Font headingfont = new Font("Comic Sans MS", Font.BOLD, 35);
    private Font subheadingfont = new Font("Montserrat", Font.BOLD, 23);
    private Font suppersubheadingfont = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 15);
    private Font font = new Font("Trebuchet MS", Font.CENTER_BASELINE, 18);

    private ResultSet rs;
    public String viewid, viewfirstname, viewdesignation, viewdob, viewcontact, viewimage, viewbloodgroup, viewgender,
            viewemail, viewpassword, viewPaddress, viewCaddress, viewJoiningDate, viewPosition, viewSalary,
            viewDuityTime, viewBranch;

    public adminView(String adminviewid) {

        f = new JFrame("Employee Management System");
        f.setSize(900, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setLayout(null);

        // icon set
        icon = new ImageIcon(getClass().getResource(".//image//icon.jpg"));
        f.setIconImage(icon.getImage());

        // body panel add
        body = new JPanel();
        body.setBounds(0, 0, 900, 700);
        body.setBackground(new Color(250, 246, 240));
        body.setLayout(null);
        f.add(body);

        DbConnect db = new DbConnect();
        try {
            rs = db.st.executeQuery("SELECT * FROM `employeeregistration` WHERE id='" + adminviewid + "'");

            while (rs.next()) {
                viewid = rs.getString("id");
                viewfirstname = rs.getString("fastname");
                viewdesignation = rs.getString("designation");
                viewdob = rs.getString("dob");
                viewcontact = rs.getString("contact");
                b = rs.getBytes("image");
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
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" + e2);
        }

        // add field
        addImageLabel = new JLabel();
        addImageLabel.setBounds(80, 50, 200, 200);
        addImageLabel.setBorder(BorderFactory.createLineBorder(new Color(35, 36, 40)));

        getimg = new ImageIcon(b);
        Image im = getimg.getImage();
        Image MyImg = im.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        setimg = new ImageIcon(MyImg);
        addImageLabel.setIcon(setimg);

        body.add(addImageLabel);

        addNameLabel = new JLabel(viewfirstname.toUpperCase());
        addNameLabel.setBounds(320, 60, 500, 50);
        addNameLabel.setFont(headingfont);
        body.add(addNameLabel);

        designationeLabel = new JLabel(viewdesignation.toUpperCase());
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

        contactLabel = new JLabel("Phone");
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
        getpaddressLabel.setBackground(Color.WHITE);
        getpaddressLabel.setBorder(BorderFactory.createLineBorder(new Color(35, 36, 40)));
        body.add(getpaddressLabel);

        caddressLabel = new JLabel("Current Address      : ");
        caddressLabel.setBounds(80, 400, 200, 50);
        caddressLabel.setFont(font);
        body.add(caddressLabel);

        getcaddressLabel = new JLabel(viewCaddress);
        getcaddressLabel.setBounds(280, 410, 500, 30);
        getcaddressLabel.setFont(suppersubheadingfont);
        getcaddressLabel.setBackground(Color.BLACK);
        getcaddressLabel.setBorder(BorderFactory.createLineBorder(new Color(35, 36, 40)));
        body.add(getcaddressLabel);

        joinDateLabel = new JLabel("Joining Date");
        joinDateLabel.setBounds(80, 460, 130, 50);
        joinDateLabel.setFont(font);
        body.add(joinDateLabel);

        getjoinDateLabel = new JLabel(viewJoiningDate);
        getjoinDateLabel.setBounds(80, 480, 200, 50);
        getjoinDateLabel.setFont(suppersubheadingfont);
        body.add(getjoinDateLabel);

        positionLabel = new JLabel("Position");
        positionLabel.setBounds(340, 460, 100, 50);
        positionLabel.setFont(font);
        body.add(positionLabel);

        getpositionLabel = new JLabel(viewPosition);
        getpositionLabel.setBounds(340, 480, 230, 50);
        getpositionLabel.setFont(suppersubheadingfont);
        body.add(getpositionLabel);

        salaryLabel = new JLabel("Salary");
        salaryLabel.setBounds(600, 460, 150, 50);
        salaryLabel.setFont(font);
        body.add(salaryLabel);

        getsalaryLabel = new JLabel(viewSalary);
        getsalaryLabel.setBounds(600, 480, 100, 50);
        getsalaryLabel.setFont(suppersubheadingfont);
        body.add(getsalaryLabel);

        duityTimeLabel = new JLabel("Duity Time");
        duityTimeLabel.setBounds(80, 530, 130, 50);
        duityTimeLabel.setFont(font);
        body.add(duityTimeLabel);

        getduityTimeLabel = new JLabel(viewDuityTime);
        getduityTimeLabel.setBounds(80, 550, 200, 50);
        getduityTimeLabel.setFont(suppersubheadingfont);
        body.add(getduityTimeLabel);

        branchLabel = new JLabel("Branch");
        branchLabel.setBounds(340, 530, 100, 50);
        branchLabel.setFont(font);
        body.add(branchLabel);

        getbranchLabel = new JLabel(viewBranch);
        getbranchLabel.setBounds(340, 550, 230, 50);
        getbranchLabel.setFont(suppersubheadingfont);
        body.add(getbranchLabel);

        close = new JButton("Back");
        close.setBounds(690, 580, 90, 40);
        close.setFont(font);
        close.setBackground(new Color(35, 36, 40));
        close.setForeground(new Color(250, 246, 240));
        close.setCursor(cursor);
        close.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(close);

        if (flag == 0) {
            JOptionPane.showMessageDialog(null, "This Id does not exist in database");
            f.dispose();
            new adminViewSearch();
        } else {
            f.setVisible(true);
        }

        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new adminViewSearch();
            }
        });
    }
}