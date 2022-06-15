package com.sprindemo.trsbackend.entry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sprindemo.trsbackend.user.User;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.time.LocalDate;

@FilterDef(name = "dateFilter",
        parameters = {
                @ParamDef(name = "entryMonth", type = "java.time.LocalDate")
        })

@Entity(name = "Entry")
@Table(name = "entry")
@Filter(name = "dateFilter", condition = "date_trunc(\"month\",date) == date_trunc(\"month\",entryMonth)")
public class Entry {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private Integer time;
    private LocalDate date;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Entry(){

    }
    public Entry(String code, Integer time, LocalDate date, String description) {
        this.code = code;
        this.time = time;
        this.date = date;
        this.description = description;
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

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
