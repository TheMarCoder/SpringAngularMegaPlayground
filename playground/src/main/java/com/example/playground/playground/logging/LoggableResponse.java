package com.example.playground.playground.logging;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by BurggrafM on 08.09.2017.
 */
public class LoggableResponse {
  private Object content;
  private Collection<String> logEntries = new ArrayList<>();

  private LoggableResponse() {
  }

  public Object getContent() {
    return content;
  }

  public Collection getLogEntries() {
    return logEntries;
  }

  public static class LoggableResponseBuilder {
    private LoggableResponse responseUnderConstruction = new LoggableResponse();

    public LoggableResponse buildResponse() {
      return responseUnderConstruction;
    }

    public LoggableResponseBuilder content(Object content) {
      responseUnderConstruction.content = content;
      return this;
    }

    public LoggableResponseBuilder logEntries(Collection<String> logEntries) {
      responseUnderConstruction.logEntries = logEntries;
      return this;
    }
  }
}
