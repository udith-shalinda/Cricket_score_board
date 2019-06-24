package com.company.input;

import com.company.gui.Gui;


public class GuiInput implements Input {
    Gui cricketScoreBoard;

    public GuiInput(Gui cricketScoreBoard) {
        this.cricketScoreBoard = cricketScoreBoard;
    }

    @Override
    public String getMatchId(){

        return cricketScoreBoard.getMatchId().getText();
    }

    @Override
    public String getSelection() {
       return (String) cricketScoreBoard.getSelection().getSelectedItem();
    }
}
