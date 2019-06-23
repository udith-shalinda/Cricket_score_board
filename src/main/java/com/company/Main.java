package com.company;

import com.company.observable.Notifier;
import com.company.observable.ObservableChange;
import com.company.database_reader.DatabaseReader;
import com.company.database_reader.Reader;
import com.company.gui.CricketScoreBoard;
import com.company.sqlconnector.Connector;
import com.company.sqlconnector.Sqlconnector;

import java.util.Observer;


public class Main {

    public static void main(String[] args) {
        Notifier notifier = new ObservableChange();


        CricketScoreBoard cricketScoreBoard = new CricketScoreBoard(notifier);
        cricketScoreBoard.setVisible(true);

        Connector connector = new Sqlconnector("admin","root");
        connector.connect();
        Reader reader = new DatabaseReader(connector,cricketScoreBoard);
        reader.read();

        ((ObservableChange) notifier).addObserver((Observer) reader);


    }
}
