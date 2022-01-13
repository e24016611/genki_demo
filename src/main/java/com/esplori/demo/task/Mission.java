package com.esplori.demo.task;

import com.esplori.demo.repository.TaskCompletedRepository;

import org.springframework.web.client.RestTemplate;

public abstract class Mission implements Runnable{
    
    private String address ;
    private TaskCompletedRepository taskCompletedRepository;
    private RestTemplate restTemplate;

    public Mission() {
    }

    public Mission(String address, TaskCompletedRepository taskCompletedRepository, RestTemplate restTemplate) {
        this.address = address;
        this.taskCompletedRepository = taskCompletedRepository;
        this.restTemplate = restTemplate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TaskCompletedRepository getTaskCompletedRepository() {
        return this.taskCompletedRepository;
    }

    public void setTaskCompletedRepository(TaskCompletedRepository taskCompletedRepository) {
        this.taskCompletedRepository = taskCompletedRepository;
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
