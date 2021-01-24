package com.odds.activityservice.service;

import com.odds.activityservice.model.Activity;
import com.odds.activityservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    public List<Activity> getByUser(String user) {
//        Activity activity = new Activity();
//        activity.setCreatedBy(user);
//        Example<Activity> example = Example.of(activity);

        return activityRepository.findAllByCreatedBy(user);
    }
}
