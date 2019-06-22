/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author udith
 */
public class Overview {
    
    public String[][] getDetails(){
        
        List<String[]> list = new ArrayList();
         
            try{  
            Class.forName("com.mysql.jdbc.Driver"); 
               System.out.println("about to connect");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket_score","root","");  
            //here sonoo is database name, root is username and password  
            Statement stmt= con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from matches where matchId = '1'");  
            while(rs.next()){
               String array[] = {rs.getString("inningOne"),rs.getString("inningTwo"),rs.getString("location"),rs.getString("winningTeam")}; 
               list.add(array);
            }
            con.close();  
            }catch(Exception e){ 
                System.out.println(e);
            } 
            
            String[][] output = new String[list.size()][4];
            for(int i=0;i<list.size();i++){
                output[i] =list.get(i);
            }
            
            return output;
    }
}
