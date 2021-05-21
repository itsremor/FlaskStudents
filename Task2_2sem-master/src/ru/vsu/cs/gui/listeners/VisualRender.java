package ru.vsu.cs.gui.listeners;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class VisualRender extends JLabel implements TableCellRenderer
{

    public VisualRender()
    {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column)
    {
        String cellValue = (String) value;

        if(cellValue.equals("Tom")) super.setBackground(Color.BLUE);

        return this;
    }

}

