package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.CircleLinkedList;
import ru.vsu.cs.gui.model.LinkedListTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {
    private JTable table;
    private LinkedListTableModel model;
    private JTextField enterKValField;
    private CircleLinkedList<String> list;

    public StartButtonListener(JTable table, JTextField enterKValField) {
        this.table = table;
        this.enterKValField = enterKValField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CircleLinkedList<String> tableData = new CircleLinkedList<>();
        CircleLinkedList<String> copiedTableData = new CircleLinkedList<>();
        model = (LinkedListTableModel) table.getModel();
        for (int count = 0; count < model.getRowCount(); count++){
            tableData.add(model.getValueAt(count, 1).toString());
            copiedTableData.add(model.getValueAt(count, 1).toString());
        }
        int index = Integer.parseInt(enterKValField.getText());
        try {


            CircleLinkedList<String> lastPerson = new CircleLinkedList<>();
            visualAnswer();
            lastPerson.add(tableData.findLastPerson(index, tableData));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void visualAnswer() {
        table.setDefaultRenderer(String.class, new VisualRender());

    }


/*
    public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

            //Cells are by default rendered as a JLabel.
            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

            //Get the status for the current row.
            LinkedListTableModel tableModel = (LinkedListTableModel) table.getModel();
            if (tableModel.getStatus(row) == LinkedListTableModel.APPROVED) {
                //возможно цикл
            }
                l.setBackground(Color.GREEN);
            } else {
                l.setBackground(Color.RED);
            }

            //Return the JLabel which renders the cell.
            return l;
    }*/

   /* public String tableFindLastPerson(int k, CircleLinkedList<String> list) throws Exception {
        list = new CircleLinkedList<>();
        Node<String> node = list.head;
        while (size > 1) {
            for (int i = 1; i < k - 1; i++) {
                node = node.getNext();
            }
            if (node.equals(tail)) {
                head = node.getNext().getNext();
            }
            if (node.getNext().equals(tail)) {
                tail = node;
            }
            node.setNext(node.getNext().getNext());
            size--;
        }
        return list.get(0);
    }*/
}
