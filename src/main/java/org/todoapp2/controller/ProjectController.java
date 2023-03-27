package org.todoapp2.controller;

import org.todoapp2.model.Project;
import org.todoapp2.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

    public void save(Project project) {
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAt,"
                + "updateAt)"
                + "VALUES(?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getName());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("ERRO ao salvar o projeto", ex);

        } finally {
            ConnectionFactory.closeConecction(connection, statement);
        }
    }

    public void update(Project project) {
        String sql = "UPDATE projects SET"
                + "name = ?,"
                + "description = ?,"
                + "createdAt= ?,"
                + "updatedAt= ?,"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("ERRO ao atualizar o projeto", ex);
        } finally {
            ConnectionFactory.closeConecction(connection, statement);
        }
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM project";
        List<Project> projects = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;


        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();


            while (resultSet.next()) {

                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updateAt"));

                projects.add(project);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao buscar os projetos",ex);
        } finally {
            ConnectionFactory.closeConecction(connection, statement, resultSet);
        }
        return projects;

    }

    public void removeById(int id) {
        String sql = "DELETE FROM project WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();


        } catch (SQLException ex) {
            try {
                new RuntimeException("ERRO ao deletar o projeto", ex);

            } finally {
                ConnectionFactory.closeConecction(connection, statement);
            }
        }
    }
}
