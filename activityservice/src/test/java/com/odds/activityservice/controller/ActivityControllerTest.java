package com.odds.activityservice.controller;

import com.odds.activityservice.model.Activity;
import com.odds.activityservice.service.ActivityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ActivityControllerTest {
    @Mock
    ActivityService activityService;

    @InjectMocks
    ActivityController activityController;

    @Test
    void getActivityShouldReturnActivityTest() {
        Activity activity = new Activity();
        activity.setId(1);
        Mockito.when(activityService.getAll()).thenReturn(Collections.singletonList(activity));

        List<Activity> actual = activityController.getActivity();

        Assertions.assertEquals(1, actual.get(0).getId());
    }
}
