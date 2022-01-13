package com.esplori.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TaskCompletedId implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String taskid;
    private String address;

    public TaskCompletedId() {
    }

    public TaskCompletedId(String taskid, String address) {
        this.taskid = taskid;
        this.address = address;
    }

    public String getTaskid() {
        return this.taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
