package com.company.sqlconnector;

import org.junit.Test;

import static org.junit.Assert.*;

public class SqlconnectorTest {

    @Test
    public void TestConnection() {
        Sqlconnector sqlconnector = new Sqlconnector("admin","root");
        sqlconnector.connect();
    }

}