package com.esplori.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Refferal {

    @JsonProperty("referral_code")
    private String referralCode;
    @JsonProperty("referee_count")
    private int refereeCount;

    public Refferal() {
    }

    public Refferal(String referralCode, int refereeCount) {
        this.referralCode = referralCode;
        this.refereeCount = refereeCount;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public int getRefereeCount() {
        return this.refereeCount;
    }

    public void setRefereeCount(int refereeCount) {
        this.refereeCount = refereeCount;
    }

    public Refferal referralCode(String referralCode) {
        setReferralCode(referralCode);
        return this;
    }

    public Refferal refereeCount(int refereeCount) {
        setRefereeCount(refereeCount);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Refferal)) {
            return false;
        }
        Refferal refferal = (Refferal) o;
        return Objects.equals(referralCode, refferal.referralCode) && refereeCount == refferal.refereeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(referralCode, refereeCount);
    }

    @Override
    public String toString() {
        return "{" +
                " referralCode='" + getReferralCode() + "'" +
                ", refereeCount='" + getRefereeCount() + "'" +
                "}";
    }

}
