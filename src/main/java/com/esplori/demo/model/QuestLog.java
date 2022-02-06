package com.esplori.demo.model;

import java.util.Objects;

public class QuestLog {
    
    private String datetime ;
    private String address;
    private String txs;
    private String retention_7;
    private String retention_14;
    private String retention_30;

    public QuestLog() {
    }

    public QuestLog(String datetime, String address, String txs, String retention_7, String retention_14, String retention_30) {
        this.datetime = datetime;
        this.address = address;
        this.txs = txs;
        this.retention_7 = retention_7;
        this.retention_14 = retention_14;
        this.retention_30 = retention_30;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTxs() {
        return this.txs;
    }

    public void setTxs(String txs) {
        this.txs = txs;
    }

    public String getRetention_7() {
        return this.retention_7;
    }

    public void setRetention_7(String retention_7) {
        this.retention_7 = retention_7;
    }

    public String getRetention_14() {
        return this.retention_14;
    }

    public void setRetention_14(String retention_14) {
        this.retention_14 = retention_14;
    }

    public String getRetention_30() {
        return this.retention_30;
    }

    public void setRetention_30(String retention_30) {
        this.retention_30 = retention_30;
    }

    public QuestLog datetime(String datetime) {
        setDatetime(datetime);
        return this;
    }

    public QuestLog address(String address) {
        setAddress(address);
        return this;
    }

    public QuestLog txs(String txs) {
        setTxs(txs);
        return this;
    }

    public QuestLog retention_7(String retention_7) {
        setRetention_7(retention_7);
        return this;
    }

    public QuestLog retention_14(String retention_14) {
        setRetention_14(retention_14);
        return this;
    }

    public QuestLog retention_30(String retention_30) {
        setRetention_30(retention_30);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuestLog)) {
            return false;
        }
        QuestLog questLog = (QuestLog) o;
        return Objects.equals(datetime, questLog.datetime) && Objects.equals(address, questLog.address) && Objects.equals(txs, questLog.txs) && Objects.equals(retention_7, questLog.retention_7) && Objects.equals(retention_14, questLog.retention_14) && Objects.equals(retention_30, questLog.retention_30);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, address, txs, retention_7, retention_14, retention_30);
    }

    @Override
    public String toString() {
        return "{" +
            " datetime='" + getDatetime() + "'" +
            ", address='" + getAddress() + "'" +
            ", txs='" + getTxs() + "'" +
            ", retention_7='" + getRetention_7() + "'" +
            ", retention_14='" + getRetention_14() + "'" +
            ", retention_30='" + getRetention_30() + "'" +
            "}";
    }



}
