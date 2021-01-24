package com.odds.accountservice.controller;

import com.odds.accountservice.exception.CommonException;
import com.odds.accountservice.model.LoginRequest;
import com.odds.accountservice.model.LoginResponse;
import com.odds.accountservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    ActivityService activityService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws CommonException {
        if (loginRequest.getUsername().isEmpty()) {
            LoginResponse failedResponse = new LoginResponse(false);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(failedResponse);
        }

        try {
            Boolean isActive = activityService.isSessionActive(loginRequest.getUsername());
            LoginResponse successResponse = new LoginResponse(isActive);

            return ResponseEntity.ok(successResponse);
        }
        catch (Exception e) {
            throw new CommonException();
        }
    }
}
