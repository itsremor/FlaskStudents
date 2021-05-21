package ru.vsu.cs.gui.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrKValueListener implements ActionListener {
    private JTextField currKValField;
    private JTextField enterKValField;

    CurrKValueListener(JTextField currKValField, JTextField enterKValField) {
        this.currKValField = currKValField;
        this.enterKValField = enterKValField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int index = Integer.parseInt(enterKValField.getText());
        for(int i = 0; i < index; i++) {
            currKValField.setText("Current k = " + index);
        }
    }
}
