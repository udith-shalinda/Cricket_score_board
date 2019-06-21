/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket_score;

import Cricket_score.Database.ConnectToDb;
import Cricket_score.Database.Mysql;

/**
 *
 * @author udith
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectToDb mysqlconnection = new Mysql();
        mysqlconnection.getConnect();
    }
    
}
