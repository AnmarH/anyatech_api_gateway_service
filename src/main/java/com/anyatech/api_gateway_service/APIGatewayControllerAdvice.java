package com.anyatech.api_gateway_service;

import lombok.extern.slf4j.Slf4j;
import model.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class APIGatewayControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Worker> handleApiValidationException() {

        Worker worker = new Worker();

        return new ResponseEntity<>(worker, HttpStatus.BAD_REQUEST);

    }


}
