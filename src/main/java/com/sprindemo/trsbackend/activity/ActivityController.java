package com.sprindemo.trsbackend.activity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ActivityController {
    @Autowired
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/addactivity")
    public void addActivity(@RequestBody ObjectNode json) throws JsonProcessingException {
        activityService.addActivity(json);

    }

    @GetMapping("/codelist")
    public List<String> getCodes(){
        return activityService.getCodes();
    }

    @GetMapping("/subcodelist")
    public List<String> getSubCodes(@RequestParam(value = "code") String code){
        return activityService.getSubCodes(code);
    }
}
