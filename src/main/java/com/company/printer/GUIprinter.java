package com.company.printer;


import com.company.gui.Gui;

import java.sql.ResultSet;

public class GUIprinter implements Printer{
    private Gui gui;

    public GUIprinter(Gui gui) {
        this.gui = gui;
    }

    @Override
    public void print(ResultSet resultSet) {

        try {
            while (resultSet.next()) {
                for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
                    gui.getTextArea().append(" " + resultSet.getObject(i));
                }
                gui.getTextArea().append("\n");
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }

    }

    public void reset(){
        this.gui.getTextArea().setText("");
    }
}
