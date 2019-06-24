package com.company.queryexecuter;

import com.company.sqlconnector.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseExecuter implements Executor {

    private Connector connector;

    public DatabaseExecuter(Connector connector){
        this.connector = connector;
    }
    @Override
    public ResultSet execute(String str) {
        Statement st = connector.connect();
        ResultSet resultSet = null;

        try {
            resultSet = st.executeQuery(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


}