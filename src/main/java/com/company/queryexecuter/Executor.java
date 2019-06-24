package com.company.queryexecuter;

import java.sql.ResultSet;

public interface Executor {
    public ResultSet execute(String str);
}
