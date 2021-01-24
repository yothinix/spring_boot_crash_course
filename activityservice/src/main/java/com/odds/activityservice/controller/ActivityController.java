package com.odds.activityservice.controller;

import com.odds.activityservice.model.Activity;
import com.odds.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivityController {

    ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(value = "/activity")
    public List<Activity> getActivity() {
        return activityService.getAll();
    }

    @GetMapping(value = "/activity/{user}")
    public List<Activity> getActivityByUser(@PathVariable(value = "user") String user) {

        return activityService.getByUser(user);
    }
}
