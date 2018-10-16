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
/**
 *
 * @author User
 */

public class SQLconnecter {
public static final String  URL="jdbc:sqlserver://localhost;databaseName=D:\\УЧЕБА\\3 КУРС\\2 СЕМЕСТР\\КУРСОВАЯ\\REM.MDF;integratedSecurity=true;";
 

    public static void main(String[] args) {
        SQLconnecter m = new SQLconnecter();
        m.testDatabase();
    }
 
    private void testDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=D:\\УЧЕБА\\3 КУРС\\2 СЕМЕСТР\\КУРСОВАЯ\\REM.MDF;integratedSecurity=true;";
 

            Connection con = DriverManager.getConnection(url);
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
