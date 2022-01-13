package com.esplori.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskCompleted {
    

    @Id
    private TaskCompletedId id;
    private String completedTime ;

    public TaskCompleted() {
    }

    public TaskCompleted(TaskCompletedId id, String completedTime) {
        this.id = id;
        this.completedTime = completedTime;
    }

    public TaskCompletedId getId() {
        return this.id;
    }

    public void setId(TaskCompletedId id) {
        this.id = id;
    }

    public String getCompletedTime() {
        return this.completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

}
