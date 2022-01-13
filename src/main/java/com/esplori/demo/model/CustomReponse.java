package com.esplori.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomReponse<T> {
    
    private boolean successed;
    @JsonProperty("errcode")
    private int errorcode ;
    private String msg; 
    private T data ;
    
    public CustomReponse() {
    }

    public CustomReponse(boolean successed, int errorcode, String msg, T data) {
        this.successed = successed;
        this.errorcode = errorcode;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccessed() {
        return this.successed;
    }

    public boolean getSuccessed() {
        return this.successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public int getErrorcode() {
        return this.errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(successed, errorcode, msg, data);
    }

    @Override
    public String toString() {
        return "{" +
            " successed='" + isSuccessed() + "'" +
            ", errorcode='" + getErrorcode() + "'" +
            ", msg='" + getMsg() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }


}
