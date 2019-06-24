package com.company;

import com.company.gui.CricketScoreBoard;
import com.company.gui.Gui;
import com.company.input.GuiInput;
import com.company.input.Input;
import com.company.observable.Notifier;
import com.company.observable.ObservableChange;
import com.company.printer.GUIprinter;
import com.company.printer.Printer;
import com.company.querycreater.Creater;
import com.company.querycreater.SqlQueryCreater;
import com.company.queryexecuter.DatabaseExecuter;
import com.company.sqlconnector.Connector;
import com.company.sqlconnector.Sqlconnector;

import java.util.Observable;
import java.util.Observer;

public class Scoreboard implements Observer {

    Notifier notifier = new ObservableChange();
    Gui gui = new CricketScoreBoard(notifier);

    public void score(){


        Connector connector = new Sqlconnector("admin","root");
        connector.connect();


        Input input = new GuiInput(gui);

        Creater creater = new SqlQueryCreater(input);

        creater.createBattingQuery();
        creater.createMatchQuery();

        Printer printer = new GUIprinter(gui);

        DatabaseExecuter executor =  new DatabaseExecuter(connector);
        printer.reset();
        printer.print(executor.execute(creater.createMatchQuery()));
        printer.print(executor.execute(creater.createBowlingQuery()));
        printer.print(executor.execute(creater.createBattingQuery()));

        connector.close();

        ((ObservableChange) notifier).addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
       score();
    }
}
