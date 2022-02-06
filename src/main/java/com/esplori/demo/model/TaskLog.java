package com.esplori.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskLog {
    
    private String datetime ;
    private String address;
    private String task;
    @JsonProperty("event_type")
    private String eventType;

    public TaskLog() {
    }

    public TaskLog(String datetime, String address, String task, String eventType) {
        this.datetime = datetime;
        this.address = address;
        this.task = task;
        this.eventType = eventType;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public TaskLog datetime(String datetime) {
        setDatetime(datetime);
        return this;
    }

    public TaskLog address(String address) {
        setAddress(address);
        return this;
    }

    public TaskLog task(String task) {
        setTask(task);
        return this;
    }

    public TaskLog eventType(String eventType) {
        setEventType(eventType);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskLog)) {
            return false;
        }
        TaskLog taskLog = (TaskLog) o;
        return Objects.equals(datetime, taskLog.datetime) && Objects.equals(address, taskLog.address) && Objects.equals(task, taskLog.task) && Objects.equals(eventType, taskLog.eventType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, address, task, eventType);
    }

    @Override
    public String toString() {
        return "{" +
            " datetime='" + getDatetime() + "'" +
            ", address='" + getAddress() + "'" +
            ", task='" + getTask() + "'" +
            ", eventType='" + getEventType() + "'" +
            "}";
    }


}
