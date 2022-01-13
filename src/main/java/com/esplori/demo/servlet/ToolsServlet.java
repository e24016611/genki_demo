package com.esplori.demo.servlet;

import java.util.ArrayList;

import com.esplori.demo.model.Skill;
import com.esplori.demo.model.Task;
import com.esplori.demo.repository.SkillRepository;
import com.esplori.demo.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tool")
public class ToolsServlet {

    @Autowired
	SkillRepository skillRepository;
	@Autowired
	TaskRepository taskRepository;
    
    @GetMapping("/init")
    boolean init(){
        boolean result = false ;
        try {
            Skill skill = new Skill();
            skill.setId("1");
            skill.setTitle("BSC快速上手系列");
            skill.setDescription("swap ant token on PancakeSwap, the largest dex of bsc");
            skill.setTasks(new ArrayList<>());
    
            Task task = new Task();
            task.setId("1");
            task.setTitle("swap ant token on PancakeSwap");
            task.setDescription("swap ant token on PancakeSwap, the largest dex of bsc");
            task.setTag_appear("bsc_tutorial");
            task.setTag_network("bsc");
            task.setTag_project("bsc");
            task.setExp(100);
            task.setLogo("resource/logo/bsc.png");
    
            skill.getTasks().add(task);
            skillRepository.save(skill);
    
            Skill test = skillRepository.findById("1").orElse(null);
            System.out.println(test);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
