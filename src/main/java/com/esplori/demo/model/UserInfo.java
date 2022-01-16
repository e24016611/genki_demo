package com.esplori.demo.model;

import java.util.Objects;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;

@Entity
public class UserInfo {

    private @Id String address;
    private Integer level;
    @JsonProperty("exp_to_next_level")
    private Integer expToNextLevel;
    @JsonProperty("referral_code")
    private String referralCode ;
    @JsonProperty("referral_url")
    private String referralUrl ;
    private String inviter;

    public UserInfo() {
    }

    public UserInfo(String address, Integer level, Integer expToNextLevel, String referralCode, String referralUrl, String inviter) {
        this.address = address;
        this.level = level;
        this.expToNextLevel = expToNextLevel;
        this.referralCode = referralCode;
        this.referralUrl = referralUrl;
        this.inviter = inviter;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExpToNextLevel() {
        return this.expToNextLevel;
    }

    public void setExpToNextLevel(Integer expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getReferralUrl() {
        return this.referralUrl;
    }

    public void setReferralUrl(String referralUrl) {
        this.referralUrl = referralUrl;
    }

    public String getInviter() {
        return this.inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public UserInfo address(String address) {
        setAddress(address);
        return this;
    }

    public UserInfo level(Integer level) {
        setLevel(level);
        return this;
    }

    public UserInfo expToNextLevel(Integer expToNextLevel) {
        setExpToNextLevel(expToNextLevel);
        return this;
    }

    public UserInfo referralCode(String referralCode) {
        setReferralCode(referralCode);
        return this;
    }

    public UserInfo referralUrl(String referralUrl) {
        setReferralUrl(referralUrl);
        return this;
    }

    public UserInfo inviter(String inviter) {
        setInviter(inviter);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(address, userInfo.address) && Objects.equals(level, userInfo.level) && Objects.equals(expToNextLevel, userInfo.expToNextLevel) && Objects.equals(referralCode, userInfo.referralCode) && Objects.equals(referralUrl, userInfo.referralUrl) && Objects.equals(inviter, userInfo.inviter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, level, expToNextLevel, referralCode, referralUrl, inviter);
    }

    @Override
    public String toString() {
        return "{" +
            " address='" + getAddress() + "'" +
            ", level='" + getLevel() + "'" +
            ", expToNextLevel='" + getExpToNextLevel() + "'" +
            ", referralCode='" + getReferralCode() + "'" +
            ", referralUrl='" + getReferralUrl() + "'" +
            ", inviter='" + getInviter() + "'" +
            "}";
    }



}
