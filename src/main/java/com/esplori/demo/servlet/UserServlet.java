package com.esplori.demo.servlet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.UserInfo;
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
            userRepository.save(new UserInfo(address, 1, 100, getMd5(address), inviter));
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
}
