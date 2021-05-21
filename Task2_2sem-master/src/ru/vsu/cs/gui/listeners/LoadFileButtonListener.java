package ru.vsu.cs.gui.listeners;

import ru.vsu.cs.common.CircleLinkedList;
import ru.vsu.cs.common.FileReader;
import ru.vsu.cs.gui.model.LinkedListTableModel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoadFileButtonListener implements ActionListener {
    private JTable table;
    private LinkedListTableModel tableModel;

    public LoadFileButtonListener(JTable table) {
        this.table = table;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src/tests"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.addChoosableFileFilter(filter);
            File file = fileChooser.getSelectedFile();
            String filename = file.getPath();
            FileReader fReader = new FileReader();
            try {
                /// TODO: Разобраться, много времени на получение данных(99% переделать модель)
                CircleLinkedList<String> dataList = fReader.toStringLinkedList(
                        fReader.getWordsArray(fReader.readFile(filename)));
                tableModel = new LinkedListTableModel(dataList);
                table.setModel(tableModel);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}