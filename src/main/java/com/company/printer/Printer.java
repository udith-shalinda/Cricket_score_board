package com.company.printer;

import java.sql.ResultSet;

public interface Printer {
    public void print(ResultSet resultSet);
    public void reset();
}
