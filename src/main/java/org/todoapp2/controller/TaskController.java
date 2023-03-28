package org.todoapp2.controller;

import org.todoapp2.model.Task;
import org.todoapp2.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class TaskController {
    public void save(){

    }

    public void update(Task task) {



    }

    public void removeById(int taskId) throws SQLException {

        String sql = "DELETE FROM task where id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {


            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();

        } catch (RuntimeException ex) {
            throw new RuntimeException("ERRO ao deletar a tarefa"+ex.getMessage(),ex);

        } finally {
            ConnectionFactory.closeConecction(connection, statement);
        }
    }

    public List<Task> getAll(int idProject) {

                return null;
    }
}
