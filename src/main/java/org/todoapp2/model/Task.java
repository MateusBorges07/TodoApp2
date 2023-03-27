package org.todoapp2.model;

import javax.xml.crypto.Data;
import java.sql.Date;

public class Task {
    private int id;
    private int idProject;
    private String name;
    private String description;
    private String nodes;
    private boolean isCompleted;
    private Data deadline;
    private Data createdAt;
    private Data updatedAt;

    public Task(int id, int idProject, String name, String description, String nodes, boolean isCompleted, Data deadline, Data createdAt, Data updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.nodes = nodes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Data getDeadline() {
        return deadline;
    }

    public void setDeadline(Data deadline) {
        this.deadline = deadline;
    }

    public Data getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Data createdAt) {
        this.createdAt = createdAt;
    }

    public Data getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Data updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", idProject=" + idProject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", nodes='" + nodes + '\'' +
                ", isCompleted=" + isCompleted +
                ", deadline=" + deadline +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
