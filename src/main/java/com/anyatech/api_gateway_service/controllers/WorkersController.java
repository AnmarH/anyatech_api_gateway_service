package com.anyatech.api_gateway_service.controllers;

import api.WorkersApi;
import lombok.RequiredArgsConstructor;
import model.Worker;
import model.Workers;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WorkersController implements WorkersApi {

    private final RestTemplate restTemplate;
    private final RetryTemplate retryTemplate;

    public ResponseEntity<Worker> getWorkerById(Long workerId) {

        return this.retryTemplate.execute(retryCallback -> restTemplate.getForEntity("http://localhost:8080/workers/{workerId}"
                ,Worker.class,workerId));
    }

    public ResponseEntity<Workers> getWorkers() {

        return this.retryTemplate.execute(retryCallback -> restTemplate.
                getForEntity("http://localhost:8080/workers",Workers.class));

    }


}
