package com.esplori.demo.repository;

import com.esplori.demo.model.Skill;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, String>{
    
}
