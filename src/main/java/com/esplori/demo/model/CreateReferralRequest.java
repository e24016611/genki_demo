package com.esplori.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateReferralRequest {
    
    private String address ;
    @JsonProperty("referral_code")
    private String referralCode;

    public CreateReferralRequest() {
    }

    public CreateReferralRequest(String address, String referralCode) {
        this.address = address;
        this.referralCode = referralCode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public CreateReferralRequest address(String address) {
        setAddress(address);
        return this;
    }

    public CreateReferralRequest referralCode(String referralCode) {
        setReferralCode(referralCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreateReferralRequest)) {
            return false;
        }
        CreateReferralRequest createReferralRequest = (CreateReferralRequest) o;
        return Objects.equals(address, createReferralRequest.address) && Objects.equals(referralCode, createReferralRequest.referralCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, referralCode);
    }

    @Override
    public String toString() {
        return "{" +
            " address='" + getAddress() + "'" +
            ", referralCode='" + getReferralCode() + "'" +
            "}";
    }

}
