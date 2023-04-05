package org.todoapp2.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DeadlineColumnCellRederer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){


        JLabel label;
        label=  (JLabel) super.getTableCellRendererComponent(table,value, isSelected,hasFocus, row, column);

        label.setHorizontalAlignment(CENTER);





        return null;
    }

}
