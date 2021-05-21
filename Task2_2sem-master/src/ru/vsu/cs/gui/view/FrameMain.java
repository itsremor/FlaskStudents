package ru.vsu.cs.gui.view;

import ru.vsu.cs.gui.listeners.LoadFileButtonListener;
import ru.vsu.cs.gui.listeners.StartButtonListener;
import ru.vsu.cs.gui.model.LinkedListTableModel;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

public class FrameMain extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private LinkedListTableModel tableModel;
    private JTextField enterKValField;
    private JTextField currKValField;
    private JButton loadFileButton;
    private JButton startButton;
    private JTextField textField1;

    public FrameMain() {
        this.setTitle("Task 2");
        this.setSize(750, 450);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.loadFileButton.addActionListener(new LoadFileButtonListener(table1));
        this.startButton.addActionListener(new StartButtonListener(table1,enterKValField));
    }
}


