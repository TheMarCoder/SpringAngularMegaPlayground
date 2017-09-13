package com.example.playground.playground.logging;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.example.playground.playground.BaseTest;

/**
 * Created by BurggrafM on 13.09.2017.
 */

public class LoggableResponseAspectTest extends BaseTest {
  public static class LoggableResponseAspectAwareService {
    public LoggableResponse loggableResponseAspectAwareMethod() {
      return new LoggableResponse
          .LoggableResponseBuilder()
          .buildResponse();
    }
  }

  @org.springframework.context.annotation.Configuration
  public static class Configuration {
    @Bean
    public LoggableResponseAspectAwareService getLoggableResponseAspectAwareService() {
      return new LoggableResponseAspectAwareService();
    }
  }

  @Autowired
  private LoggableResponseAspectAwareService loggableResponseAspectAwareService;

  @Autowired
  private LogEntryStorage logEntryStorage;

  @Test
  public void testLoggableResponseAspect() {
    logEntryStorage
      .pushLine("line 1")
      .pushLine("line 2");

    LoggableResponse response =
      loggableResponseAspectAwareService.loggableResponseAspectAwareMethod();

    Assert.assertEquals("Expected that response contains 2 log entries, inserted by LoggableResponseAspect",
      2, response.getLogEntries().size());
  }
}
