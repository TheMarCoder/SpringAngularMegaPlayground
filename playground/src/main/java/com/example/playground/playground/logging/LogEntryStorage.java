package com.example.playground.playground.logging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by BurggrafM on 12.09.2017.
 */
@Service
public class LogEntryStorage {
  private List<String> logEntries = new ArrayList<>();

  public synchronized LogEntryStorage pushLine(String line) {
    logEntries.add(line);
    return this;
  }

  public synchronized List<String> popAll() {
    List<String> result = new ArrayList<>(logEntries);
    logEntries.clear();
    return result;
  }
}
