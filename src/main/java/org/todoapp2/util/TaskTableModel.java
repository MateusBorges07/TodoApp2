package org.todoapp2.util;

import org.todoapp2.model.Task;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {


String[] colums ={"nome", "descricação", "prazo","tarefa concluida","editar","excluir"};
List<Task>tasks = new ArrayList<>();




    @Override
    public int getRowCount() {
        return tasks.size();

    }

    @Override
    public int getColumnCount() {
        return colums.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 1:

                return tasks.get(rowIndex).getName();
                break;

            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

            default:
        }
    }
}
