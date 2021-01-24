package com.odds.activityservice.service;

import com.odds.activityservice.model.Activity;
import com.odds.activityservice.repository.ActivityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {
    @Mock
    ActivityRepository activityRepository;

    @InjectMocks
    ActivityService activityService;

    @Test
    void getAllShouldReturnActivityTest() {
        Activity activity = new Activity();
        activity.setId(1);
        activity.setName("Login");
        activity.setDescription("HuMan is logged in");
        List<Activity> activities = Collections.singletonList(activity);
        Mockito.when(activityRepository.findAll()).thenReturn(activities);

        Activity actual = activityService.getAll().get(0);

        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("Login", actual.getName());
        Assertions.assertEquals("HuMan is logged in", actual.getDescription());
    }
}
