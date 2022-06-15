package com.sprindemo.trsbackend.entry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sprindemo.trsbackend.user.User;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity(name = "Entry")
@Table(name = "entry")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entry {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private Integer time;
    private LocalDate date;
    private String description;

    private String subCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Entry(){

    }

    public Entry(String code, Integer time, String date, String description, String subCode) {
        this.code = code;
        this.time = time;
        this.subCode = subCode;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        this.date = LocalDate.parse(date,formatter);
        this.description = description;
    }
    public Entry(String code, Integer time, LocalDate date, String description, String subCode) {
        this.code = code;
        this.time = time;
        this.date = date;
        this.description = description;
        this.subCode = subCode;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Entry)) return false;
        return id != null && id.equals(((Entry)o).getId());

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public long getId() {
        return id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", subCode='" + subCode + '\'' +
                ", user=" + user +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }
}
