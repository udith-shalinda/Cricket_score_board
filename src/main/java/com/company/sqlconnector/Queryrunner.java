package com.company.sqlconnector;

import java.sql.ResultSet;

public interface Queryrunner {
    public ResultSet runQuery(String sql);
}
