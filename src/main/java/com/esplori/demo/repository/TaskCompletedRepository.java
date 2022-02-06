package com.esplori.demo.repository;

import java.util.List;

import com.esplori.demo.model.TaskCompleted;
import com.esplori.demo.model.TaskCompletedId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCompletedRepository extends CrudRepository<TaskCompleted, TaskCompletedId>{

    @Query("from TaskCompleted where address = ?1")
    List<TaskCompleted> findByAddress(String address);

    @Query("from TaskCompleted where taskid = ?1")
    List<TaskCompleted> findByTaskid(String taskid);
}
