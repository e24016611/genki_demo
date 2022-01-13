package com.esplori.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Skill {
    
    @Id
    private String id;
    private String title;
    private String description;
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private List<Task> tasks ;

    public Skill() {
    }

    public Skill(String id, String title, String description, String logo, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.logo = logo;
        this.tasks = tasks;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Skill id(String id) {
        setId(id);
        return this;
    }

    public Skill title(String title) {
        setTitle(title);
        return this;
    }

    public Skill description(String description) {
        setDescription(description);
        return this;
    }

    public Skill logo(String logo) {
        setLogo(logo);
        return this;
    }

    public Skill tasks(List<Task> tasks) {
        setTasks(tasks);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Skill)) {
            return false;
        }
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) && Objects.equals(title, skill.title) && Objects.equals(description, skill.description) && Objects.equals(logo, skill.logo) && Objects.equals(tasks, skill.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, logo, tasks);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", logo='" + getLogo() + "'" +
            ", tasks='" + getTasks() + "'" +
            "}";
    }


}
