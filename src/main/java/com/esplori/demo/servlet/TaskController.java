package com.esplori.demo.servlet;

import java.util.Map;

import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.Task;
import com.esplori.demo.model.TaskCompletedId;
import com.esplori.demo.repository.TaskCompletedRepository;
import com.esplori.demo.repository.TaskRepository;
import com.esplori.demo.task.SwapMission;
import com.esplori.demo.task.TaskObserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskCompletedRepository taskCompletedRepository;
    @Autowired
    TaskObserver taskObserver;
    
    @GetMapping("/{task_id}")
    CustomReponse<Task> getTask(@PathVariable String task_id, @RequestParam(required = false) String address){
        CustomReponse<Task> result = new CustomReponse<>();
        try {
            Task task = taskRepository.findById(task_id).get();
            if(address != null){
                if (taskCompletedRepository.existsById(new TaskCompletedId(task.getId(), address))) {
                    task.setCompleted(true);
                }
            }
            result.setData(task);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/{task_id}/start")
    CustomReponse<String> startTask(@PathVariable String task_id, @RequestBody Map<String, Object> payload){
        CustomReponse<String> result = new CustomReponse<>();
        String address = String.valueOf(payload.get("address"));
        SwapMission swapMission = new SwapMission();
        swapMission.setAddress(address);
        taskObserver.observe(swapMission);
        result.setSuccessed(true);
        return result;
    }
    
}
