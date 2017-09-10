package com.example.playground.playground.logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import com.example.playground.playground.BaseTest;

/**
 * Created by BurggrafM on 08.09.2017.
 */
public class LoggableResponseBuilderTest /*extends BaseTest*/ {
  private LoggableResponse.LoggableResponseBuilder responseBuilder = new LoggableResponse.LoggableResponseBuilder();

  @Test
  public void testInstantiateResponseBuilder() {
    Assert.assertNotNull("Expected that LoggableResponseBuilder could be instantiated", responseBuilder);
  }

  @Test
  public void testBuildLoggableResponse() {
    LoggableResponse loggableResponse = responseBuilder.buildResponse();
    Assert.assertNull("Expected that empty response has no content", loggableResponse.getContent());
    Assert.assertEquals("Expected that empty response has no log entries", 0, loggableResponse.getLogEntries().size());
  }

  @Test
  public void testBuildLoggableResponseWithContentOnly() {
    LoggableResponse loggableResponse =
      responseBuilder
          .content("test content string")
        .buildResponse();

    Assert.assertEquals("Expected that response has correct content type", String.class, loggableResponse.getContent().getClass());
    Assert.assertEquals("Expected that response has correct content", "test content string", loggableResponse.getContent());
    Assert.assertEquals("Expected that empty response has no log entries", 0, loggableResponse.getLogEntries().size());
  }

  @Test
  public void testBuildLoggableResponseWithLogEntriesOnly() {
    Collection<String> logEntries = new ArrayList<>();
    logEntries.add("logEntry 1");
    logEntries.add("logEntry 2");

    LoggableResponse loggableResponse =
      responseBuilder
          .logEntries(logEntries)
        .buildResponse();

    Assert.assertNull("Expected that empty response has no content", loggableResponse.getContent());
    Assert.assertEquals("Expected that empty response has 2 log entries", logEntries, loggableResponse.getLogEntries());
  }

  @Test
  public void testBuildLoggableResponseWithContentAndLogEntries() {
    UUID uuidContent = UUID.randomUUID();
    Collection<String> logEntries = new ArrayList<>();
    logEntries.add("logEntry 1");
    logEntries.add("logEntry 2");

    LoggableResponse loggableResponse =
      responseBuilder
          .content(uuidContent)
          .logEntries(logEntries)
        .buildResponse();

    Assert.assertEquals("Expected that response has correct content type", uuidContent.getClass(), loggableResponse.getContent().getClass());
    Assert.assertEquals("Expected that response has correct content", uuidContent, loggableResponse.getContent());
    Assert.assertEquals("Expected that empty response has 2 log entries", logEntries, loggableResponse.getLogEntries());
  }
}
