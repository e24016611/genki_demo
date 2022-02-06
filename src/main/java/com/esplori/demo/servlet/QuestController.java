package com.esplori.demo.servlet;

import java.util.ArrayList;
import java.util.List;

import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.QuestLog;
import com.esplori.demo.model.Skill;
import com.esplori.demo.model.Task;
import com.esplori.demo.model.TaskCompleted;
import com.esplori.demo.model.UserInfo;
import com.esplori.demo.repository.SkillRepository;
import com.esplori.demo.repository.TaskCompletedRepository;
import com.esplori.demo.repository.UserInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/quests")
@RestController
public class QuestController {
    
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    TaskCompletedRepository taskCompletedRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    private static ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("")
    CustomReponse<List<ObjectNode>> getAllQuests(@RequestParam(required = false) String address) {
        CustomReponse<List<ObjectNode>> result = new CustomReponse<>();
        try {
            List<ObjectNode> skills = new ArrayList<>();
            for (Skill skill : skillRepository.findAll()) {
                skills.add(fullfillQuest(skill));
            }
            result.setData(skills);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/{quest_id}")
    CustomReponse<ObjectNode> getQuest(@PathVariable String quest_id, @RequestParam(required = false) String address) {
        CustomReponse<ObjectNode> result = new CustomReponse<>();
        try {
            Skill skill = skillRepository.findById(quest_id).get();
            ObjectNode data = fullfillQuest(skill);
            result.setData(data);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/{quest_id}/history")
    CustomReponse<List<QuestLog>> getQusetHistory(@PathVariable String quest_id, @RequestParam(required = false) String address) {
        CustomReponse<List<QuestLog>> result = new CustomReponse<>();
        try {
            List<QuestLog> data = new ArrayList<>();
            Skill skill = skillRepository.findById(quest_id).get();
            if (skill.getTasks() != null) {
                for (Task task : skill.getTasks()) {
                    String taskid = task.getId();
                    List<TaskCompleted> taskCompleteds = taskCompletedRepository.findByTaskid(taskid);
                    for (TaskCompleted taskCompleted : taskCompleteds) {
                        QuestLog questLog = new QuestLog(taskCompleted.getCompletedTime(), taskCompleted.getId().getAddress(), "0xafBc06C22aA5....", "0xafBc06C22aA5....", "0xafBc06C22aA5....", "0xafBc06C22aA5....");
                        data.add(questLog);
                    }
                }
            }
            result.setData(data);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private ObjectNode fullfillQuest(Skill skill){
        int impression = 0;
        int participants = 0;
        int referrals = 0;
        if (skill.getTasks() != null) {
            for (Task task : skill.getTasks()) {
                String taskid = task.getId();
                List<TaskCompleted> taskCompleteds = taskCompletedRepository.findByTaskid(taskid);
                for (TaskCompleted taskCompleted : taskCompleteds) {
                    try {
                        impression ++ ;
                        participants ++;
                        String address = taskCompleted.getId().getAddress();
                        UserInfo userInfo = userInfoRepository.findById(address).get();
                        if(userInfo.getInviter() != null){
                            referrals++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        ObjectNode jsonObject = objectMapper.convertValue(skill, ObjectNode.class);
        jsonObject.put("impression", impression);
        jsonObject.put("participants", participants);
        jsonObject.put("referrals", referrals);
        return jsonObject;
    }

}
