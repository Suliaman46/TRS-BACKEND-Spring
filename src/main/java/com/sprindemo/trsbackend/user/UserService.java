package com.sprindemo.trsbackend.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprindemo.trsbackend.entry.Entry;


import com.sprindemo.trsbackend.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntryService entryService;
    @Autowired
    public UserService(UserRepository userRepository, EntryService entryService) {
        this.userRepository = userRepository;
        this.entryService = entryService;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String name){
        return userRepository.findByUserName(name);
    }


    public List<Entry> getUserEntries(String name, String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate date = LocalDate.parse(dateString,formatter);

        User user = this.getUser(name);
        if(user == null){
            this.createUser(name);
            return Collections.emptyList();
        }
        List<Entry> temp = user.getEntries();
        List<Entry> toReturn = new ArrayList<>();
        for (Entry entry: temp
             ) {
            if(entry.getDate().getMonth() == date.getMonth()) toReturn.add(entry);
        }

        return toReturn;
    }

    private void createUser(String name) {
        userRepository.save(new User(name));
    }
    @Transactional
    public void addUserEntry(ObjectNode json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Entry entry = objectMapper.treeToValue(json.get("entryDetails"),Entry.class);
        String userName = json.get("userName").asText();
        userRepository.findByUserName(userName).addEntry(entry);
    }

    public void editUserEntry(ObjectNode json) {
        String userName = json.get("userName").asText();
        String subCode = json.get("entryDetails").get("subCode").asText();
        String description = json.get("entryDetails").get("description").asText();
        Integer time = json.get("entryDetails").get("time").asInt();
        Long id = json.get("entryDetails").get("id").asLong();
        entryService.updateEntry(id,subCode,description,time);
    }

    public void deleteUserEntry(ObjectNode json) {
        String userName = json.get("userName").asText();
        Long id = json.get("id").asLong();
        Entry toDelete = entryService.getEntry(id).get();
        userRepository.findByUserName(userName).removeEntry(toDelete);
        entryService.deleteEntry(toDelete);

    }
}
