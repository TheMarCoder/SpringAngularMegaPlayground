package com.example.playground.playground.healthCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.playground.playground.logging.LogEntryStorage;
import com.example.playground.playground.logging.LoggableResponse;

/**
 * Created by dorom on 31.05.2017.
 */
@RestController
public class HealthCheckServiceRest {
    @Autowired
    private LogEntryStorage logEntryStorage;

    @GetMapping(value = "/healthCheck")
    public LoggableResponse healthCheck() {
      logEntryStorage.pushLine("@GetMapping(value = '/healthCheck') called");

      return new LoggableResponse.LoggableResponseBuilder()
          .content("backend healthCheck ... OK")
          .buildResponse();
    }
}
