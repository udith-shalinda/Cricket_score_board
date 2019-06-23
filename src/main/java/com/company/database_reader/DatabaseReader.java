package com.company.database_reader;

import com.company.gui.CricketScoreBoard;
import com.company.sqlconnector.Connector;
import com.company.sqlconnector.Queryrunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class DatabaseReader implements Reader, Observer {

    private Queryrunner queryrunner;
    CricketScoreBoard cricketScoreBoard;

    public DatabaseReader(Connector connector, CricketScoreBoard cricketScoreBoard){
        this.queryrunner = (Queryrunner) connector;
        this.cricketScoreBoard = cricketScoreBoard;
    }
    @Override
    public void read() {
        this.cricketScoreBoard.textArea1.setText("");
        int i1=1;
        int i2=1;
        int matchId;
        String selection;

        try {
            matchId = Integer.parseInt(cricketScoreBoard.getMatchId());
        }catch(Exception exception){
            matchId = 1;
        }
        selection = cricketScoreBoard.getSelection();

        switch (selection){
            case "innings 1":
                i1 =1;
                i2 =1;
                break;
            case "innings 2":
                i1 = 2;
                i2 = 2;
                break;
            case "overview":
                    i1= 1;
                    i2 = 2;
                    break;
                    default:break;
        }

        String sql = "SELECT * FROM  batting ba, bowling bo WHERE bo.matchId = " + matchId  + " AND bo.inning = "+ i1 +" AND ba.inning = "+i2 ;
        ResultSet resultSet = queryrunner.runQuery(sql);
        System.err.println(sql);
            try {
                while (resultSet.next()) {
                    for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                        cricketScoreBoard.textArea1.append(" " +  resultSet.getObject(i));
                    }
                    cricketScoreBoard.textArea1.append("\n");

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }





    }

    @Override
    public void update(Observable o, Object arg) {
        this.read();
    }
}