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
public class Solution {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       SQLConnecter cone=new SQLConnecter();
    String mes=   cone.con("Select id  from dbo.enter where loginn='ad' and passwordd=123;");
      System.out.println(mes);
     
    }
    
}
