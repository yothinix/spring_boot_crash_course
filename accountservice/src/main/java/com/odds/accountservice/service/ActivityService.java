package com.odds.accountservice.service;

import com.odds.accountservice.client.ActivityServiceClient;
import com.odds.accountservice.exception.CommonException;
import com.odds.accountservice.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityServiceClient activityServiceClient;

    public Boolean isSessionActive(String user) {
//        List<Activity> userActivity = getActivityByName(user);
        List<Activity> userActivity = activityServiceClient.getActivityByUser(user);

        return userActivity.stream().anyMatch(activity -> activity.getName().equals("Logout"));
    }

    public List<Activity> getActivityByName(String user) throws CommonException {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<List<Activity>> response = restTemplate.exchange(
                    "http://localhost:8080/activity/" + user,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Activity>>() {
                    });
            if (response.getStatusCode().equals(HttpStatus.OK)) {
                return response.getBody();
            } else {
                throw new CommonException();
            }

        } catch (Exception e) {
            throw new CommonException();
        }
    }
}
