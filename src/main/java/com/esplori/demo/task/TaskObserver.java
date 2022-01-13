package com.esplori.demo.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.esplori.demo.repository.TaskCompletedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskObserver {

    @Autowired
    TaskCompletedRepository taskCompletedRepository;
    @Autowired
    RestTemplate restTemplate;
    
    private static ExecutorService threadPool = Executors.newFixedThreadPool(8);

    public void observe(Mission mission){
        mission.setRestTemplate(restTemplate);
        mission.setTaskCompletedRepository(taskCompletedRepository);
        threadPool.submit(mission);
    }


}
