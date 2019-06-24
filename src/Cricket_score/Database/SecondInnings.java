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
public class SecondInnings {
    
    private String matchId;
    
    public SecondInnings(String matchId){
        this.matchId = matchId;
    }
    public String[][] getDetails(){
        List<String[]> list = new ArrayList();
        int Firstlist;
         
            try{  
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket_score","root","");  
            //here sonoo is database name, root is username and password  
            Statement stmt= con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from batting where inning = 2 and matchId = '"+ this.matchId +"'");  
            while(rs.next()){
                String array[] = {rs.getString("playerId"),rs.getString("Score"),rs.getString("fours"),rs.getString("sixes"),rs.getString("wicketStatus"),rs.getString("average")}; 
                list.add(array);
            }
            Firstlist = list.size();
            for(int i=0;i<list.size();i++){
                String[] playeradd = list.get(i);
                ResultSet player = stmt.executeQuery("select * from players where playerId = "+playeradd[0]);
                while(player.next()){
                    playeradd[0] = player.getString("playerName");
                }
                list.remove(i);
                list.add(i,playeradd);
            }
            String[] array = {"","","","",""};
            list.add(array);
            String[] secondHeader = {"Player name", "wickets", "runs","overs","maidens","Avarege"};
            list.add(secondHeader);
            //adding second array
            
            ResultSet rs1=stmt.executeQuery("select * from bowling where inning = 1 and matchId = '"+this.matchId+"'");   //innin error
            while(rs1.next()){
               String array1[] = {rs1.getString("playerId"),rs1.getString("wicket"),rs1.getString("runs"),rs1.getString("overs"),rs1.getString("maidens"),rs1.getString("average")}; 
               list.add(array1);
            }
            for(int i=Firstlist+2;i<list.size();i++){
                String[] playeradd = list.get(i);
                ResultSet player = stmt.executeQuery("select * from players where playerId = "+playeradd[0]);
                while(player.next()){
                    playeradd[0] = player.getString("playerName");
                }
                list.remove(i);
                list.add(i,playeradd);
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
