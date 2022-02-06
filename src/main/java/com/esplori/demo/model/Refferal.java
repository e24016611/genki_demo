package com.esplori.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Refferal {

    @JsonProperty("referral_code")
    private String referralCode;
    @JsonProperty("referee_count")
    private int refereeCount;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("total_points")
    private int totalPoints;

    public Refferal() {
    }

    public Refferal(String referralCode, int refereeCount, int rank, int totalPoints) {
        this.referralCode = referralCode;
        this.refereeCount = refereeCount;
        this.rank = rank;
        this.totalPoints = totalPoints;
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

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Refferal referralCode(String referralCode) {
        setReferralCode(referralCode);
        return this;
    }

    public Refferal refereeCount(int refereeCount) {
        setRefereeCount(refereeCount);
        return this;
    }

    public Refferal rank(int rank) {
        setRank(rank);
        return this;
    }

    public Refferal totalPoints(int totalPoints) {
        setTotalPoints(totalPoints);
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
        return Objects.equals(referralCode, refferal.referralCode) && refereeCount == refferal.refereeCount && rank == refferal.rank && totalPoints == refferal.totalPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(referralCode, refereeCount, rank, totalPoints);
    }

    @Override
    public String toString() {
        return "{" +
            " referralCode='" + getReferralCode() + "'" +
            ", refereeCount='" + getRefereeCount() + "'" +
            ", rank='" + getRank() + "'" +
            ", totalPoints='" + getTotalPoints() + "'" +
            "}";
    }

}
