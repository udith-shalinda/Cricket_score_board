package com.company.sqlconnector;

import java.sql.*;

public class Sqlconnector implements Connector{
    Connection con;
    ResultSet re;
    Statement st;
    private String user;
    private String password;

    public Sqlconnector(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public Statement connect() {



        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/cricket",this.user,this.password);
            st = con.createStatement();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }



    public void close(){
        if (re != null) {
            try {
                re.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) { /* ignored */}
        }
    }

}
