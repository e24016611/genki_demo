package com.esplori.demo.repository;

import com.esplori.demo.model.Task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, String>{
    
}
