package com.sprindemo.trsbackend.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
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
