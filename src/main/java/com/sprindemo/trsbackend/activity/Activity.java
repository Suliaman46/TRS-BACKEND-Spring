package com.sprindemo.trsbackend.activity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String manager;
    private String name;
    private Integer budget;
    private Boolean active;
    @ElementCollection
    private List<String> subactivities = new ArrayList<>();

    public Activity(){

    }
    public Activity(String code, String manager, String name, Integer budget, Boolean active, List<String> subactivities) {
        this.code = code;
        this.manager = manager;
        this.name = name;
        this.budget = budget;
        this.active = active;
        this.subactivities = subactivities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<String> getSubactivities() {
        return subactivities;
    }

    public void setSubactivities(List<String> subactivities) {
        this.subactivities = subactivities;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "code='" + code + '\'' +
                '}';
    }
}
