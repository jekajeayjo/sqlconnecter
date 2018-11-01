/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlconnecter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import static sqlconnecter.MyServerFrame.mes;

/**
 *
 * @author User
 */
public class ServConnecter  extends Thread {
    
   public void send ()
   {
   try
{

Socket s=     new Socket("192.168.0.100",8081);   
PrintWriter pw=new PrintWriter(s.getOutputStream());
pw.write(mes);
pw.flush();
pw.close();
s.close();
System.out.println("Send:"+mes);
}
catch(IOException e)
{
e.printStackTrace();
}
   }
    
    
    
    
}
