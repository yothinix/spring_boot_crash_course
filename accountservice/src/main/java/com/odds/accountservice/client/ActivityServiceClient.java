package com.odds.accountservice.client;

import com.odds.accountservice.model.Activity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${activity.service.name}", url = "${activity.service.url}")
public interface ActivityServiceClient {

    @GetMapping(value = "/activity")
    public List<Activity> getActivity();

    @GetMapping(value = "/activity/{user}")
    public List<Activity> getActivityByUser(@PathVariable(value = "user") String user);
}
