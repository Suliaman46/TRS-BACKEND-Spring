package com.sprindemo.trsbackend.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sprindemo.trsbackend.entry.Entry;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    public List<Entry> getEntries() {
        return entries;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Entry> entries = new ArrayList<>();

    public User(){

    }
    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User(String userName){
        this.userName = userName;
    }

    public void addEntry(Entry entry){
        entries.add(entry);
        entry.setUser(this);
    }

    public void removeEntry(Entry entry){
        entries.remove(entry);
        entry.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
