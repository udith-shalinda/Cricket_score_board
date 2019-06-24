package com.company.gui;

import com.company.observable.Notifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CricketScoreBoard extends JFrame implements Gui{
    private JPanel rootpane;
    private JPanel westLabelPane;
    private JPanel southTextPane;
    private JPanel east;
    private JTextField textField1;
    private JButton search;
    private JTextArea textArea1;
    private JButton clear;
    private JLabel id;
    private JLabel select;
    private JComboBox Selection;
    Notifier observableChange;

    public CricketScoreBoard(final Notifier observableChange) {
        add(rootpane);
        this.observableChange = observableChange;

        setTitle("Cricket Score Board");
        setSize(1300,750);
        setVisible(true);


        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observableChange.change();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textArea1.setText("");
            }
        });
    }

    public JTextField getMatchId() {
        return textField1;
    }

    public JComboBox getSelection() {
        return  Selection;
    }

    public JTextArea getTextArea() {
        return textArea1;
    }


}
