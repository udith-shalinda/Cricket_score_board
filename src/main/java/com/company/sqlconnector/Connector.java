package com.company.sqlconnector;

import java.sql.Statement;

public interface Connector {
    public Statement connect();
    public void close();
}
