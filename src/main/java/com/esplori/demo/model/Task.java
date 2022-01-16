package com.esplori.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Task {
    
    @Id
    private String id ;
    private String skill_id;
    private String title ;
    private String description;
    private String tag_appear;
    private String tag_network;
    private String tag_project;
    private Integer exp;
    @JsonInclude()
    @Transient
    private boolean completed;
    private String logo; 
    private String redirect_url;

    public Task() {
    }

    public Task(String id, String skill_id, String title, String description, String tag_appear, String tag_network, String tag_project, Integer exp, boolean completed, String logo, String redirect_url) {
        this.id = id;
        this.skill_id = skill_id;
        this.title = title;
        this.description = description;
        this.tag_appear = tag_appear;
        this.tag_network = tag_network;
        this.tag_project = tag_project;
        this.exp = exp;
        this.completed = completed;
        this.logo = logo;
        this.redirect_url = redirect_url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkill_id() {
        return this.skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag_appear() {
        return this.tag_appear;
    }

    public void setTag_appear(String tag_appear) {
        this.tag_appear = tag_appear;
    }

    public String getTag_network() {
        return this.tag_network;
    }

    public void setTag_network(String tag_network) {
        this.tag_network = tag_network;
    }

    public String getTag_project() {
        return this.tag_project;
    }

    public void setTag_project(String tag_project) {
        this.tag_project = tag_project;
    }

    public Integer getExp() {
        return this.exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public Task id(String id) {
        setId(id);
        return this;
    }

    public Task skill_id(String skill_id) {
        setSkill_id(skill_id);
        return this;
    }

    public Task title(String title) {
        setTitle(title);
        return this;
    }

    public Task description(String description) {
        setDescription(description);
        return this;
    }

    public Task tag_appear(String tag_appear) {
        setTag_appear(tag_appear);
        return this;
    }

    public Task tag_network(String tag_network) {
        setTag_network(tag_network);
        return this;
    }

    public Task tag_project(String tag_project) {
        setTag_project(tag_project);
        return this;
    }

    public Task exp(Integer exp) {
        setExp(exp);
        return this;
    }

    public Task completed(boolean completed) {
        setCompleted(completed);
        return this;
    }

    public Task logo(String logo) {
        setLogo(logo);
        return this;
    }

    public Task redirect_url(String redirect_url) {
        setRedirect_url(redirect_url);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(skill_id, task.skill_id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(tag_appear, task.tag_appear) && Objects.equals(tag_network, task.tag_network) && Objects.equals(tag_project, task.tag_project) && Objects.equals(exp, task.exp) && completed == task.completed && Objects.equals(logo, task.logo) && Objects.equals(redirect_url, task.redirect_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill_id, title, description, tag_appear, tag_network, tag_project, exp, completed, logo, redirect_url);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", skill_id='" + getSkill_id() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", tag_appear='" + getTag_appear() + "'" +
            ", tag_network='" + getTag_network() + "'" +
            ", tag_project='" + getTag_project() + "'" +
            ", exp='" + getExp() + "'" +
            ", completed='" + isCompleted() + "'" +
            ", logo='" + getLogo() + "'" +
            ", redirect_url='" + getRedirect_url() + "'" +
            "}";
    }


}
