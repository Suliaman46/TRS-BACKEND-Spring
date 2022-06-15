package com.sprindemo.trsbackend.user;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sprindemo.trsbackend.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/Home")
    public List<Entry> getUserEntries(@RequestParam(value = "userName") String name,@RequestParam("dateString") String dateString){
        return userService.getUserEntries(name, dateString);
    }
    @PostMapping("/addentry")
    public void addUserEntry(@RequestBody ObjectNode json) throws IOException {
        userService.addUserEntry(json);
    }
    @PutMapping("/editentry")
    public void editUserEntry(@RequestBody ObjectNode json){
        userService.editUserEntry(json);
    }
    @DeleteMapping("/Home")
    public void deleteUserEntry(@RequestBody ObjectNode json){
        userService.deleteUserEntry(json);
    }


}
