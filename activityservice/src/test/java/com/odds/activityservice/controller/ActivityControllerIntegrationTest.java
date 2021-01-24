package com.odds.activityservice.controller;

import com.odds.activityservice.model.Activity;
import com.odds.activityservice.service.ActivityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class ActivityControllerIntegrationTest {
    @MockBean
    ActivityService activityService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getActivityShouldReturnActivity() throws Exception {
        Activity activity = new Activity();
        activity.setId(1);
        Mockito.when(activityService.getAll()).thenReturn(Collections.singletonList(activity));

        ResultActions actual = mockMvc.perform(MockMvcRequestBuilders.get("/activity"));

        actual.andExpect(status().isOk());
        actual.andExpect(content().string("[{\"id\":1,\"name\":null,\"description\":null,\"createdAt\":null,\"createdBy\":null}]"));
    }
}
