import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.regex.*;

public class Registration extends JFrame {

    private JFrame f;
    private JPanel body;
    private JLabel heading, addImageLabel, photoFormate, addImgLabel, email, logolabel, firstName, designation,
            contactNumber, dateOfBirth, parmanentAddress, currentAddress, bloodGroup, confirmPassword, password,
            dateFormate, ortxt, gender;
    private JTextField inputFirstName, inputDesignation, inputContactNumber, inputEmail, inputDateOfBirth,
            inputParmanentAddress, inputCurrentAddress, inputBloodGroup;
    private JButton addImageBtn, signinBtn, registerBtn;
    private ImageIcon icon, addImage, logo, chooseImage;
    private JCheckBox checkBox;
    private JPasswordField inputPassword, inputConfirmPassword;
    private JRadioButton male, female;
    private JFileChooser fileChooser;
    private String imagePath, ugender = "";
    private int flag = 0;
    private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    private JLabel[] label = new JLabel[11];
    private JTextField[] textFields = new JTextField[8];
    private JPasswordField[] passFields = new JPasswordField[2];

    private Font headingfont = new Font("Courier", Font.BOLD, 35);
    private Font txtfont = new Font("Arial", Font.BOLD, 13);
    private Font photofont = new Font("Arial", Font.BOLD, 15);

    public Registration() {

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
        body.setBackground(new Color(0, 32, 63));
        body.setLayout(null);
        f.add(body);

        // logo add
        logo = new ImageIcon(getClass().getResource(".//image//R_logo.png"));
        logolabel = new JLabel(logo);
        logolabel.setBounds(30, 10, logo.getIconWidth(), logo.getIconHeight());
        body.add(logolabel);

        heading = new JLabel("Employee Registration");
        heading.setFont(headingfont);
        heading.setForeground(new Color(173, 239, 209));
        heading.setBounds(100, 12, 500, 45);
        body.add(heading);

        addImageLabel = new JLabel();
        addImageLabel.setBounds(50, 100, 200, 200);
        addImageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(addImageLabel);

        addImage = new ImageIcon(getClass().getResource(".//image//addimg.png"));
        addImgLabel = new JLabel(addImage);
        addImgLabel.setBounds(80, 130, addImage.getIconWidth(), addImage.getIconHeight());
        body.add(addImgLabel);

        addImageBtn = new JButton("Choose File");
        addImageBtn.setBounds(280, 110, 110, 30);
        addImageBtn.setBackground(new Color(173, 239, 209));
        addImageBtn.setForeground(Color.BLACK);
        addImageBtn.setFont(photofont);
        addImageBtn.setCursor(cursor);
        addImageBtn.setBorder(null);
        body.add(addImageBtn);

        photoFormate = new JLabel("(Upload only jpg, jpeg or png file.)");
        photoFormate.setForeground(Color.WHITE);
        photoFormate.setBounds(280, 145, 190, 15);
        body.add(photoFormate);

        // naming label field
        firstName = new JLabel("First Name : ");
        designation = new JLabel("Designation : ");
        contactNumber = new JLabel("Contact Number : ");
        email = new JLabel("Email : ");
        dateOfBirth = new JLabel("Date of Birth : ");
        parmanentAddress = new JLabel("Parmanent Address: ");
        currentAddress = new JLabel("Current Address: ");
        bloodGroup = new JLabel("Blood Group: ");
        gender = new JLabel("Gender: ");
        password = new JLabel("Password: ");
        confirmPassword = new JLabel("Confirm Password: ");

        firstName.setBounds(550, 90, 100, 15);
        designation.setBounds(550, 160, 100, 15);
        contactNumber.setBounds(550, 230, 140, 15);
        dateOfBirth.setBounds(280, 230, 140, 15);
        bloodGroup.setBounds(50, 320, 140, 15);
        gender.setBounds(360, 320, 140, 15);
        email.setBounds(550, 320, 140, 15);
        password.setBounds(50, 400, 140, 15);
        confirmPassword.setBounds(400, 400, 180, 15);
        parmanentAddress.setBounds(50, 470, 140, 15);
        currentAddress.setBounds(50, 540, 140, 15);

        label[0] = firstName;
        label[1] = designation;
        label[2] = contactNumber;
        label[3] = email;
        label[4] = dateOfBirth;
        label[5] = parmanentAddress;
        label[6] = currentAddress;
        label[7] = bloodGroup;
        label[8] = password;
        label[9] = confirmPassword;
        label[10] = gender;

        for (int i = 0; i < 11; i++) {
            label[i].setFont(txtfont);
            label[i].setForeground(Color.WHITE);
            body.add(label[i]);
        }

        // //input field
        inputFirstName = new JTextField();
        inputDesignation = new JTextField();
        inputContactNumber = new JTextField();
        inputEmail = new JTextField();
        inputDateOfBirth = new JTextField();
        inputParmanentAddress = new JTextField();
        inputCurrentAddress = new JTextField();
        inputBloodGroup = new JTextField();

        inputFirstName.setBounds(550, 110, 270, 30);
        inputDesignation.setBounds(550, 180, 270, 30);
        inputContactNumber.setBounds(550, 250, 270, 30);
        inputDateOfBirth.setBounds(280, 250, 200, 30);
        inputBloodGroup.setBounds(50, 340, 270, 30);
        inputEmail.setBounds(550, 340, 270, 30);
        inputParmanentAddress.setBounds(50, 490, 600, 30);
        inputCurrentAddress.setBounds(50, 560, 600, 30);

        textFields[0] = inputFirstName;
        textFields[1] = inputDesignation;
        textFields[2] = inputContactNumber;
        textFields[3] = inputDateOfBirth;
        textFields[4] = inputBloodGroup;
        textFields[5] = inputEmail;
        textFields[6] = inputParmanentAddress;
        textFields[7] = inputCurrentAddress;

        for (int i = 0; i < 8; i++) {
            textFields[i].setFont(txtfont);
            textFields[i].setBackground(new Color(225, 229, 232));
            textFields[i].setForeground(Color.BLACK);
            textFields[i].setBorder(null);
            body.add(textFields[i]);
        }

        // //add pass field
        inputPassword = new JPasswordField();
        inputConfirmPassword = new JPasswordField();

        inputPassword.setBounds(50, 420, 300, 30);
        inputConfirmPassword.setBounds(400, 420, 300, 30);

        passFields[0] = inputPassword;
        passFields[1] = inputConfirmPassword;

        for (int i = 0; i < 2; i++) {
            passFields[i].setFont(txtfont);
            passFields[i].setBackground(new Color(225, 229, 232));
            passFields[i].setForeground(Color.BLACK);
            passFields[i].setBorder(null);
            body.add(passFields[i]);
        }

        // checkbox add
        checkBox = new JCheckBox("Show Password");
        checkBox.setBounds(710, 425, 120, 15);
        checkBox.setBackground(null);
        checkBox.setForeground(new Color(173, 239, 209));
        checkBox.setBorder(null);
        body.add(checkBox);

        // button add
        registerBtn = new JButton("Register");
        registerBtn.setBounds(700, 510, 100, 35);
        registerBtn.setBackground(new Color(173, 239, 209));
        registerBtn.setForeground(Color.BLACK);
        registerBtn.setCursor(cursor);
        registerBtn.setFont(photofont);
        registerBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        body.add(registerBtn);

        signinBtn = new JButton("Sign in");
        signinBtn.setForeground(new Color(173, 239, 209));
        signinBtn.setBackground(new Color(0, 32, 63));
        signinBtn.setBorder(null);
        signinBtn.setBounds(730, 570, 45, 15);
        signinBtn.setCursor(cursor);
        signinBtn.setFont(txtfont);
        body.add(signinBtn);

        // naming label add
        dateFormate = new JLabel("Use formate (dd.mm.yyyy)");
        dateFormate.setForeground(Color.WHITE);
        dateFormate.setBounds(280, 285, 160, 15);
        body.add(dateFormate);

        ortxt = new JLabel("---------------- Or ---------------");
        ortxt.setForeground(Color.WHITE);
        ortxt.setFont(txtfont);
        ortxt.setBounds(675, 550, 180, 15);
        body.add(ortxt);

        // //radio button add
        ButtonGroup btngroup = new ButtonGroup();
        btngroup.add(male);
        btngroup.add(female);

        male = new JRadioButton("Male");
        male.setBounds(360, 340, 60, 20);
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(0, 32, 63));
        male.setFont(txtfont);
        male.setBorder(null);
        body.add(male);

        female = new JRadioButton("Female");
        female.setBounds(440, 340, 80, 20);
        female.setForeground(Color.WHITE);
        female.setBackground(new Color(0, 32, 63));
        female.setFont(txtfont);
        female.setBorder(null);
        body.add(female);

        f.setVisible(true);

        checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    inputPassword.setEchoChar((char) 0);
                    inputConfirmPassword.setEchoChar((char) 0);
                } else {
                    inputPassword.setEchoChar('\u25CF');
                    inputConfirmPassword.setEchoChar('\u25CF');
                }
            }
        });

        male.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (male.isSelected()) {
                    female.setSelected(false);
                    ugender = "Male";
                }
            }
        });

        female.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (female.isSelected()) {
                    male.setSelected(false);
                    ugender = "Female";
                }
            }
        });

        addImageBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == addImageBtn) {
                    try {
                        fileChooser = new JFileChooser();
                        fileChooser.setAcceptAllFileFilterUsed(false);
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
                        fileChooser.addChoosableFileFilter(filter);

                        int result = fileChooser.showDialog(null, "Open");
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File file = fileChooser.getSelectedFile();
                            imagePath = file.getAbsolutePath();
                            chooseImage = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 200,
                                    Image.SCALE_SMOOTH));
                            addImageLabel.setIcon(chooseImage);
                            flag = 1;

                        } else if (result == JFileChooser.CANCEL_OPTION) {
                            JOptionPane.showMessageDialog(null, "No file selected");
                        }
                    } catch (Exception e2) {
                        System.err.println("image error: " + e2);
                    }
                }
            }
        });

        signinBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new signin();
            }
        });

        registerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // get input text
                String ufname = inputFirstName.getText();
                String udesignation = inputDesignation.getText();
                String udob = inputDateOfBirth.getText();
                String ucontactnumber = inputContactNumber.getText();
                String ubloodgroup = inputBloodGroup.getText();
                String uemail = inputEmail.getText();
                String upass = inputPassword.getText();
                String ucpass = inputConfirmPassword.getText();
                String upaddress = inputParmanentAddress.getText();
                String ucaddress = inputCurrentAddress.getText();

                // validation input field
                String nameRegex = "^[a-zA-Z. ]+$";
                String dobRegex = "((0[1-9])|([1-2][0-9])|(3[0-1])).((0[1-9])|(1[0-2])).((19[0-9][0-9])|(20[0-1][0-9])|(202[0-1]))$";
                String mobileRegex = "(\\+88)?01[3-9]\\d{8}";
                String bloodRegex = "((AB\\+)|(AB\\-)|(A\\+)|(A\\-)|(B\\+)|(B\\-)|(O\\+)|(O\\-))$";
                String emailRegex = "[a-z0-9.]+@[a-z]+[.[a-z]]+$";
                String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{10,}$";
                String addressRegex = "[A-Za-z0-9'\\.\\-\\s\\,\\/]+$";

                // condition
                if (!Pattern.matches(nameRegex, ufname)) {
                    JOptionPane.showMessageDialog(null, "In-valid First Name");
                }

                else if (!Pattern.matches(nameRegex, udesignation)) {
                    JOptionPane.showMessageDialog(null, "In-valid Designation");
                }

                else if (!Pattern.matches(dobRegex, udob)) {
                    JOptionPane.showMessageDialog(null,
                            "In-valid Date of Birth. \r\n" + "You must be follow this format (dd.mm.yyyy)");
                }

                else if (!Pattern.matches(mobileRegex, ucontactnumber)) {
                    JOptionPane.showMessageDialog(null, "In-valid Phone Number");
                }

                else if (!Pattern.matches(bloodRegex, ubloodgroup)) {
                    JOptionPane.showMessageDialog(null,
                            "In-valid Blood Group. \r\n" + "You must write following this format (AB+ / O- / A+)");
                }

                else if (!((male.isSelected()) || (female.isSelected()))) {
                    JOptionPane.showMessageDialog(null, "Select your gender");
                }

                else if (!Pattern.matches(emailRegex, uemail)) {
                    JOptionPane.showMessageDialog(null, "In-valid E-mail");
                }

                else if (flag == 0) {
                    JOptionPane.showMessageDialog(null, "Upload your picture");
                }

                else if (!upass.equals(ucpass)) {
                    JOptionPane.showConfirmDialog(null, "Password & confirm password is not matching");
                }

                else if (!Pattern.matches(passRegex, upass)) {
                    JOptionPane.showMessageDialog(null, "Your password is not secure. Please set a strong password \r\n"
                            + "with 10 digits using uppercase, lowercase and special character");
                }

                else if (!Pattern.matches(addressRegex, upaddress)) {
                    JOptionPane.showMessageDialog(null, "In-valid parmanent address");
                }

                else if (!Pattern.matches(addressRegex, ucaddress)) {
                    JOptionPane.showMessageDialog(null, "In-valid current address");
                }

                else {
                    // for register query
                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaems", "root", "");

                        String queryInsert = "INSERT INTO `employeeregistration`(`fastname`,`designation`, `dob`, `contact`, `image`, `bloodgroup`, `gender`, `email`,`password`, `Paddress`, `Caddress`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(queryInsert);
                        FileInputStream uimage = new FileInputStream(imagePath);

                        pst.setString(1, inputFirstName.getText());
                        pst.setString(2, inputDesignation.getText());
                        pst.setString(3, inputDateOfBirth.getText());
                        pst.setString(4, inputContactNumber.getText());
                        pst.setBinaryStream(5, uimage, uimage.available());
                        pst.setString(6, inputBloodGroup.getText());
                        pst.setString(7, ugender);
                        pst.setString(8, inputEmail.getText());
                        pst.setString(9, inputPassword.getText());
                        pst.setString(10, inputParmanentAddress.getText());
                        pst.setString(11, inputCurrentAddress.getText());

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registration Complete Successfully");
                        f.dispose();
                        new signin();
                    } catch (Exception e3) {
                        JOptionPane.showMessageDialog(null, "Not Inserted any Data !!" + e3);
                    }
                }
            }
        });
    }
}
