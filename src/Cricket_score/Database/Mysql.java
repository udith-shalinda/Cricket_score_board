/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Mysql implements ConnectToDb {

    @Override
    public void getConnect() {
       try{  
        Class.forName("com.mysql.jdbc.Driver"); 
           System.out.println("about to connect");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket_score","root","");  
        //here sonoo is database name, root is username and password  
        Statement stmt= con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from matches");  
        while(rs.next())  
        System.out.println(rs.getString("matchId")+"  "+rs.getString("inningOne")+"  "+rs.getString("inningTwo"));  
        con.close();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}
    
