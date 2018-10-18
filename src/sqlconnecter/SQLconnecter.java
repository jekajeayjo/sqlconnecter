/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnecter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 *
 * @author User
 */

public class SQLconnecter {
     private static String username = "kob";
    private static String password = "w3347986";
public static final String  URL=" jdbc:sqlserver://127.0.0.1:1433;databaseName=rem.mdf;";

 

    public static void main(String[] args) {
        SQLconnecter m = new SQLconnecter();
        m.testDatabase();
    }
 
    private void testDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        
 

            Connection con = DriverManager.getConnection(URL,username,password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM  Clients");
                while (rs.next()) {
                    String str = rs.getString("ID") + ":" + rs.getString(2);
                    System.out.println("Contact:" + str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
