package com.esplori.demo.repository;

import java.util.List;

import com.esplori.demo.model.UserInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
    
    Long countByInviter(String referralCode);
    List<UserInfo> findByInviter(String inviter);
}
