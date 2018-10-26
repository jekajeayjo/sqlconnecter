/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnecter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 *
 * @author User
 */
public class SQLConnecter extends ServConnecter  {
     private static String username = "kob";
    private static String password = "w3347986";
    private static String URL = "jdbc:sqlserver://WIN-6RRA6PLK3SE\\MSSQLSERVER:1433;DatabaseName=rem.mdf";
    private String  ur="";
    public String con(String s)
    {
         String mes="";
        ur=s;
            try
        {
 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(URL, username, password);
 
          //  if (connection != null) System.out.println("Connection Successful !\n");
            if (connection == null) System.exit(0);
 
            /*String query = "insert into regis.dbo.Диагноз (Код_диагноза, Название) values (2, 'name')";*/
            Statement statement = connection.createStatement();
 
            //statement.executeQuery(query);
            ResultSet rs = statement.executeQuery(ur);
            //ResultSet получает результирующую таблицу
            int x = rs.getMetaData().getColumnCount();
            //Resultset.getMetaData() получаем информацию
            //результирующей таблице
           
            while (rs.next())
            {
                for (int i = 1; i <= x; i++)
                {
                    mes+=rs.getString(i);
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();
           
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
 
        } catch (Exception e)
        {
            e.printStackTrace();
        }
         return mes;
        
    }
}
