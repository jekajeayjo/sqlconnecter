/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnecter;
import java.sql.*;
/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws ClassNotFoundException {
        // TODO code application logic here
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       
        try {
           
            Connection con = 
 DriverManager.getConnection(
                    "jdbc:sqlserver://127.0.0.1:1433;databaseName=rem.mdf;integratedSecurity=true;"
                    //"jdbc:sqlserver://127.0.0.1:1433", "sa", "****"
                    );
                   if(con!=null){
                       System.out.println("Connection Successful!\n");
                   }
         Statement statement = con.createStatement();
         String queryString = "select * from Clients";
         ResultSet rs = statement.executeQuery(queryString);
         while (rs.next()) {
            System.out.println(rs.getString(2)+"\n");
         }
 
                    
        } catch (SQLException ex) {
            System.out.println("Error Trace in getConnection() : " + ex.getMessage());
        }
    }
    }
    

