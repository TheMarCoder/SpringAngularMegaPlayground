package com.example.playground.playground.logging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by BurggrafM on 08.09.2017.
 */
public class LoggableResponse implements Serializable {
  private Serializable content;
  private Collection<String> logEntries = new ArrayList<>();

  private LoggableResponse() {
  }

  public Serializable getContent() {
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

    public LoggableResponseBuilder content(Serializable content) {
      responseUnderConstruction.content = content;
      return this;
    }

    public LoggableResponseBuilder logEntries(Collection<String> logEntries) {
      responseUnderConstruction.logEntries = logEntries;
      return this;
    }
  }
}
