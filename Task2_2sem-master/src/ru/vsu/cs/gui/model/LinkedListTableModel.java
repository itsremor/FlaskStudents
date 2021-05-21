package ru.vsu.cs.gui.model;

import jdk.jshell.Snippet;
import ru.vsu.cs.common.CircleLinkedList;

import javax.swing.table.AbstractTableModel;

public class LinkedListTableModel extends AbstractTableModel {
    private final CircleLinkedList<String> data;
    private final String[] colNames = {"List"};

    public LinkedListTableModel(CircleLinkedList<String> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.getSize();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return data.get(rowIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
