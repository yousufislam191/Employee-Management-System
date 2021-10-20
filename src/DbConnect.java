import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    
    public Connection con;
    public Statement st;

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                 //Connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaems","root","");
                st = con.createStatement();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Database :" +e);
        }
    }
}
