package com.odds.accountservice.config;

import com.odds.accountservice.exception.CommonException;
import com.odds.accountservice.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({ CommonException.class })
    public ResponseEntity<ErrorResponse> handleGenericException(final Exception e, final WebRequest request) {
        ErrorResponse response = new ErrorResponse("500", "account-service", "Generic Error");
        return ResponseEntity.ok(response);
    }
}
