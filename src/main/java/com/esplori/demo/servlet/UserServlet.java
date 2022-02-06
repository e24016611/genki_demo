package com.esplori.demo.servlet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.Task;
import com.esplori.demo.model.TaskCompleted;
import com.esplori.demo.model.TaskLog;
import com.esplori.demo.model.UserInfo;
import com.esplori.demo.repository.TaskCompletedRepository;
import com.esplori.demo.repository.TaskRepository;
import com.esplori.demo.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user/")
@RestController
public class UserServlet {

    @Autowired
    UserInfoRepository userRepository;
    @Autowired
    TaskCompletedRepository taskCompletedRepository;
    @Autowired
    TaskRepository taskRepository;
    
    @GetMapping("{address}")
    CustomReponse<UserInfo> getUser(@PathVariable String address){

        CustomReponse<UserInfo> result = new CustomReponse<>();
        try {
            Optional<UserInfo> userInfo = userRepository.findById(address);
            if(userInfo.isPresent()){
                result.setData(userInfo.get());
                result.setSuccessed(true);
            }else{
                result.setErrorcode(1);
                result.setMsg("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setErrorcode(2);
        }
        return result;
    }

    @PutMapping("{address}")
    CustomReponse<String> creaateUser(@PathVariable String address, @RequestParam(required = false) String inviter){
        CustomReponse<String> result = new CustomReponse<>();
        try {
            String md5Address = getMd5(address);
            userRepository.save(new UserInfo(address, 1, 100, md5Address, "invite/" + md5Address, inviter ));
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @GetMapping("{address}/history/dapp")
    CustomReponse<List<TaskLog>> getHistoryDapp(@PathVariable String address, @RequestParam(required = false) String sdate, @RequestParam(required = false) String edate){
        CustomReponse<List<TaskLog>> result = new CustomReponse<>();
        try {
            List<TaskCompleted> taskCompleteds = taskCompletedRepository.findByAddress(address);
            List<TaskLog> data = new ArrayList<>();
            for (TaskCompleted taskCompleted : taskCompleteds) {
                data.add(generateFromTaskCompleted(taskCompleted));
            }
            result.setData(data);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    

    @GetMapping("{address}/history/referral")
    CustomReponse<List<TaskLog>> getHistoryReferral(@PathVariable String address, @RequestParam(required = false) String sdate, @RequestParam(required = false) String edate){
        CustomReponse<List<TaskLog>> result = new CustomReponse<>();
        try {
            String md5Address = getMd5(address);
            List<UserInfo> userInfos = userRepository.findByInviter(md5Address); 
            List<TaskLog> data = new ArrayList<>();
            for (UserInfo userInfo : userInfos) {
                List<TaskCompleted> taskCompleteds = taskCompletedRepository.findByAddress(userInfo.getAddress());
                for (TaskCompleted taskCompleted : taskCompleteds) {
                    data.add(generateFromTaskCompleted(taskCompleted));
                }
            }
            result.setData(data);
            result.setSuccessed(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getMd5(String input) 
    { 
        try { 
    
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
    
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
    
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
    
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
    
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

    private TaskLog generateFromTaskCompleted(TaskCompleted taskCompleted){
        TaskLog taskLog = null;
        try {
            Task task = taskRepository.findById(taskCompleted.getId().getTaskid()).get();
            taskLog = new TaskLog(taskCompleted.getCompletedTime(), taskCompleted.getId().getAddress(), task.getTitle(), "event type #1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskLog;
    }
}
