package com.eci.cosw.springbootsecureapi.model;

/**
 * Task
 */
public class Task {
    private String id;
    private String status;
    private String description;
    private String nameResponsible;
    private String dueDate;
    private String emailResponsible;

    public Task (String id, String status, String description, String dueDate, String emailResponsible) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.dueDate = dueDate;
        this.emailResponsible = emailResponsible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEmailResponsible() {
        return emailResponsible;
    }

    public void setEmailResponsible(String emailResponsible) {
        this.emailResponsible = emailResponsible;
    }
    public String getNameResponsible() {
        return nameResponsible;
    }

    public void setNameResponsible(String nameResponsible) {
        this.nameResponsible = nameResponsible;
    }

}