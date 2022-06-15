package com.sprindemo.trsbackend.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;


    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    public List<String> getCodes() {
        List<Activity> activities =  activityRepository.findAll();
        List<String> toReturn = new ArrayList<>();
        for (Activity activity: activities
        ) {
            toReturn.add(activity.getCode());
        };
        return toReturn;
    }

    public List<String> getSubCodes(String code) {
        return activityRepository.findByCode(code).getSubactivities();
    }
}
