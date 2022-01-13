package com.esplori.demo.repository;

import com.esplori.demo.model.TaskCompleted;
import com.esplori.demo.model.TaskCompletedId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCompletedRepository extends CrudRepository<TaskCompleted, TaskCompletedId>{
    
}
