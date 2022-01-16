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
            skill.setTitle("BSC");
            skill.setSubtitle("Explore popular Dapps and accelerate your crypto journey");
            skill.setDescription("BSC Explorer (Swap, Yield Farming, and more…)");
            skill.setLogo("resource/bsc.jpg");
            skill.setTasks(new ArrayList<>());
    
            Task task = new Task();
            task.setId("1");
            task.setTitle("Swap token on the BNB-BUSD pair");
            task.setDescription("swap any token on PancakeSwap, the largest DEX on BSC");
            task.setTag_appear("bsc_tutorial");
            task.setTag_network("bsc");
            task.setTag_project("bsc");
            task.setExp(100);
            task.setLogo("resource/pancake.jpg");
            task.setRedirect_url("https://pancakeswap.finance/swap");

            Skill skill2 = new Skill();
            skill2.setId("2");
            skill2.setTitle("SOLANA");
            skill2.setDescription("Solana Explorer (Coming soon)");
            skill2.setLogo("resource/solana.jpg");
            skill2.setTasks(new ArrayList<>());
    
            skill.getTasks().add(task);
            skillRepository.save(skill);
            skillRepository.save(skill2);
    
            Skill test = skillRepository.findById("1").orElse(null);
            System.out.println(test);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
