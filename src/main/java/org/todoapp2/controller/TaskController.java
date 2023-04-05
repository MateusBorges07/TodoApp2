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
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject"
                +"name,"
                +"description"
                +"completed,"
                +"notes"
                +"deadline,"
                +"createdAt"
                +"updateAt) VALUES (?,?,?,?,?,?,?,?)";

        Connection connection =null;
        PreparedStatement statement =null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4,task.isIsCompleted());
            statement.setString(5,task.getNodes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        }catch (Exception ex){
            throw new RuntimeException("ERRO ao salvar a tarefa"+ ex.getMessage(), ex);

        }finally {
            ConnectionFactory.closeConecction(connection, statement);
        }
    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET"
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "nodes = ?, "
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updateAt = ?,"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            //estabelecnedo a conexao com o banco
            connection = ConnectionFactory.getConnection();

            //preparando a query
            statement = connection.prepareStatement(sql);

            //setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNodes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
            statement.setInt(9,task.getId());

            //executando a query
            statement.execute();



        }catch (Exception ex){
            throw new RuntimeException("ERRO ao atualizar a tarefa"+ex.getMessage(),ex);
        }


    }

    public void removeById(int taskId)  {

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
        String sql ="SELECT * FROM tasks WHERE idProjetct = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //Lista de Taredas que sera devolvida quando a chamada do metodo acontecer
        List<Task> tasks = new ArrayList<Task>();
        try {
            //criação da conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            //valor retornado pela execucao da query
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProjetcct"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNodes(resultSet.getString("nodes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setCreatedAt(resultSet.getDate("createAt"));
                task.setUpdatedAt(resultSet.getDate("updateAt"));
                tasks.add(task);
            }
        }catch (Exception ex){
            throw new RuntimeException("ERRO ao LISTAR a tarefa"+ex.getMessage(),ex);
        }finally {
            ConnectionFactory.closeConecction(connection,statement, resultSet);
        }
        //lista de tarefas que foi criada e carregada do banco de dados
        return tasks;
    }

}


