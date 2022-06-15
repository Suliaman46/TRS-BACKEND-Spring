package com.sprindemo.trsbackend.user;

import com.sprindemo.trsbackend.entry.Entry;
import com.sprindemo.trsbackend.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;
//    private final EntryService entryService;
//
//    @Autowired
//    public UserController(UserService userService, EntryService entryService){
//        this.userService = userService;
//        this.entryService = entryService;
//    }
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/entries")
    public List<Entry> getUserEntries(@RequestParam(value = "name") String name,@RequestParam("dateString") String dateString){
//        return entryService.getUserEntries(userService.getUser(name));
        return userService.getUserEntries(name, dateString);
    }


}
