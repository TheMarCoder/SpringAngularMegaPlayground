package com.example.playground.playground.healthCheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dorom on 31.05.2017.
 */
@RestController
public class HealthCheckServiceRest {
    @GetMapping(value = "/healthCheck")
    public HealthCheckTO healthCheck() {
        return new HealthCheckTO();
    }
}
