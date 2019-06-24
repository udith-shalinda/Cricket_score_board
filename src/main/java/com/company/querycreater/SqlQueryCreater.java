package com.company.querycreater;

import com.company.input.Input;


public class SqlQueryCreater implements Creater {
    private Input input;
    String  matchId =null;
    String selection;

    public SqlQueryCreater(Input input) {
        this.input = input;
    }

    @Override
    public String createBowlingQuery() {

        matchId = "1";
        selection = input.getSelection();

        final String sql = " select p.playername,p.team,bo.overs,bo.wicket,bo.runs,bo.maidens,bo.average from matches m,players p,bowling bo where p.playerid = bo.playerid AND m.matchId = bo.matchId  ";

        if("innings 1".equals(selection)){
            if(matchId == null)
                return sql + " AND bo.inning = 1";
            else
                return  sql +"AND bo.matchId =" +matchId + " and bo.inning = 1";
        }else if("innings 2".equals(selection)) {
            if(matchId == null)
                return sql + " AND bo.inning = 2";
            else
                return  sql +"AND bo.matchId = " +matchId + " and bo.inning = 2";
        }else if("overview".equals(selection)){
            if(matchId == null)
                return sql ;
            else
                return sql + " AND bo.matchId = " +matchId ;
        }else{
            return null;
        }

    }

    @Override
    public String createBattingQuery() {

        matchId = "1";
        selection = input.getSelection();

        final String sql = " select p.playername,p.team,ba.score,ba.balls,ba.fours,ba.sixes,ba.wicketStatus from matches m,players p,batting ba where p.playerid = ba.playerid AND m.matchId = ba.matchId ";

        if("innings 1".equals(selection)){
            if(matchId == null)
                return sql + " and ba.inning = 1";
            else
            return  sql +"and ba.matchId = " +matchId + " and ba.inning = 1";
        }else if("innings 2".equals(selection)) {
            if(matchId == null)
                return sql + " and ba.inning = 2";
            else
                return  sql +"and ba.matchId = " +matchId + " and ba.inning = 2";
        }else if("overview".equals(selection)){
            if(matchId == null)
                return sql ;
            else
                return sql + " and ba.matchId = " +matchId ;
        }else{
            return null;
        }
    }

    @Override
    public String createMatchQuery() {
        matchId = "1";
        selection = input.getSelection();

        if(matchId == null)
            return " select * from matches";
        else
            return "select * from matches where matchID = "+matchId;
    }

}
