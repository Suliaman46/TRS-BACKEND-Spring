package com.sprindemo.trsbackend.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sprindemo.trsbackend.entry.Entry;
import com.sprindemo.trsbackend.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/Home")
    public List<Entry> getUserEntries(@RequestParam(value = "name") String name,@RequestParam("dateString") String dateString){
        return userService.getUserEntries(name, dateString);
    }
    @PostMapping("/addEntry")
    public void addUserEntry(@RequestBody ObjectNode json) throws IOException {
        userService.addUserEntry(json);
    }
    @PutMapping("/editEntry")
    public void editUserEntry(@RequestBody ObjectNode json){
        userService.editUserEntry(json);
    }
    @DeleteMapping("/Home")
    public void deleteUserEntry(@RequestBody ObjectNode json){
        userService.deleteUserEntry(json);
    }


}
