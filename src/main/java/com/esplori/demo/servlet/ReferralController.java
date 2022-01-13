package com.esplori.demo.servlet;

import java.util.Optional;

import com.esplori.demo.model.CreateReferralRequest;
import com.esplori.demo.model.CustomReponse;
import com.esplori.demo.model.Refferal;
import com.esplori.demo.model.UserInfo;
import com.esplori.demo.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/referral/")
@RestController
public class ReferralController {
    
    @Autowired
    UserInfoRepository userRepository;

    @GetMapping("{address}")
    CustomReponse<Refferal> queryRefferalInfo(@PathVariable String address){
        CustomReponse<Refferal> response = new CustomReponse<>();
        try {
            Optional<UserInfo> userInfo = userRepository.findById(address);
            if(userInfo.isPresent()){
                UserInfo user = userInfo.get();
                Refferal refferal = new Refferal();
                refferal.setReferralCode(user.getReferralCode());
                refferal.setRefereeCount(userRepository.countByInviter(user.getReferralCode()).intValue());
                response.setData(refferal);
                response.setSuccessed(true);
            }else{
                response.setErrorcode(1);
                response.setMsg("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setErrorcode(2);
        }

        return response;
    }

    @PostMapping("/")
    CustomReponse<String> createRefferal(@RequestBody CreateReferralRequest request ){
        CustomReponse<String> response = new CustomReponse<>();
        try {
            Optional<UserInfo> userInfo = userRepository.findById(request.getAddress());
            if(userInfo.isPresent()){
                UserInfo user = userInfo.get();
                user.setInviter(request.getReferralCode());
                userRepository.save(user);
                response.setSuccessed(true);
            }else{
                response.setErrorcode(1);
                response.setMsg("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setErrorcode(2);
        }
        return response;
    }
    

}
