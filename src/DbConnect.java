import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int flag = 0;

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                 //Connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaems","root","");
                st = con.createStatement();
                rs = st.executeQuery("select * from admin");
        } 
        catch (Exception e) {
            System.err.println("Error : " +e);
        }
    }

     //for login query
     public void Signin(String signinQuery, String signinUserEmail, String signinUserPass) {
        
        try {
            //admin email & pass 
            String adminemail = "admin.employeems@gmail.com";
            String adminpass = "@dm21InEMS#";

            rs = st.executeQuery(signinQuery);
            while(rs.next()) {
                String tableUserEmail = rs.getString(2);
                String tablePass = rs.getString(3);

                if (signinUserEmail.equals(tableUserEmail) && signinUserPass.equals(tablePass)) {
                    flag = 1;
                    break;
                }
            }
            if(signinUserEmail.equals(adminemail) && signinUserPass.equals(adminpass)) {
                JOptionPane.showMessageDialog(null, "Successfully Admin Panel login");
                new admin();
            }
            else if(flag == 0) {
                JOptionPane.showMessageDialog(null, "wrong username & password");
            }
            else {
                JOptionPane.showMessageDialog(null, "Successfully User login");
                new userPanle();
            }
        }
        catch (Exception e) {
            System.err.println("Login Error :"+e);
        }
    }
}
