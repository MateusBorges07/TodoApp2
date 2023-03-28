package org.todoapp2;

import org.todoapp2.controller.ProjectController;
import org.todoapp2.model.Project;
import org.todoapp2.util.ConnectionFactory;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProjectController projectController = new ProjectController();

        Project project = new Project();
        project.setName("projeto teste");
        project.setDescription("description");
        projectController.save(project);



//        project.setName("novo nome do projeto");
//        projectController.update(project);
//
//        List<Project>projects = projectController.getAll();
//        System.out.println("total de projetos = "+projects.size());
    }
}