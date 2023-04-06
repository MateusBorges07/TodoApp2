package org.todoapp2.util;

import org.todoapp2.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Date;

public class DeadlineColumnCellRederer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){


        JLabel label;
        label=  (JLabel) super.getTableCellRendererComponent(table,value, isSelected,hasFocus, row, column);

        label.setHorizontalAlignment(CENTER);

        TaskTableModel tableModel = (TaskTableModel) table.getModel();
        Task task = tableModel.getTasks().get(NEXT);
        if (task.getDeadline().after(new Date())){
            label.setBackground(Color.green);
        }else {
            label.setBackground(Color.red);
        }



        return label;
    }

}
