package com.esplori.demo.servlet;

import java.util.ArrayList;
import java.util.List;

import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.Skill;
import com.esplori.demo.model.Task;
import com.esplori.demo.model.TaskCompletedId;
import com.esplori.demo.repository.SkillRepository;
import com.esplori.demo.repository.TaskCompletedRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/skill")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;
    @Autowired
    TaskCompletedRepository taskCompletedRepository;

    private static ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/all")
    CustomReponse<List<ObjectNode>> getAllSkills(@RequestParam(required = false) String address) {
        CustomReponse<List<ObjectNode>> result = new CustomReponse<>();
        
        try {
            List<ObjectNode> skills = new ArrayList<>();
            for (Skill skill : skillRepository.findAll()) {
                int task_completed = 0;
                if (skill.getTasks() != null) {
                    if (address != null) {
                        for (Task task : skill.getTasks()) {
                            if (taskCompletedRepository.existsById(new TaskCompletedId(task.getId(), address))) {
                                task_completed ++ ;
                            }
                        }
                    }
                }
                
                ObjectNode jsonObject = objectMapper.convertValue(skill, ObjectNode.class);
                jsonObject.put("task_total", skill.getTasks().size());
                jsonObject.put("task_completed", task_completed);
                jsonObject.remove("tasks");
                skills.add(jsonObject);
            }
             
            result.setData(skills);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/{skill_id}")
    CustomReponse<Skill> getSkill(@PathVariable String skill_id, @RequestParam(required = false) String address) {
        CustomReponse<Skill> result = new CustomReponse<>();
        try {
            Skill skill = skillRepository.findById(skill_id).get();
            if (skill.getTasks() != null) {
                if (address != null) {
                    for (Task task : skill.getTasks()) {
                        if (taskCompletedRepository.existsById(new TaskCompletedId(task.getId(), address))) {
                            task.setCompleted(true);
                        }
                    }
                }
            }
            result.setData(skill);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
