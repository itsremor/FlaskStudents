package ru.vsu.cs.gui.listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LastPersonButtonListener implements ActionListener {
    private JTextField inputField;
    private JTextField resultField;

    public LastPersonButtonListener(JTextField inputField, JTextField resultField) {
        this.inputField = inputField;
        this.resultField = resultField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        String sourceData = inputField.getText();
        CircleLinkedList<Integer> sourceList = FileReader.toIntList(sourceData);
        int answer = 0;
        try {
            answer = sourceList.findLastPerson(sourceList);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        resultField.setText(Integer.toString(answer));
    }*/
    }
}
