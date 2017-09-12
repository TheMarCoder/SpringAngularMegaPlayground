package com.example.playground.playground.logging;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.playground.playground.BaseTest;

/**
 * Created by BurggrafM on 12.09.2017.
 */
public class LogEntryStorageTest extends BaseTest {

  @Autowired
  private LogEntryStorage logEntryStorage;

  @Test
  public void testInstantiateLogEntryStorageServiceTest() {
    Assert.assertNotNull("Expected that LogEntryStorageService could be instantiated", logEntryStorage);
  }

  @Test
  public void testStoreAndGetStoredLogEntries() {
    logEntryStorage
      .pushLine("logEntry 1")
      .pushLine("logEntry 2");

    List<String> logEntries = logEntryStorage.popAll();

    Assert.assertEquals("Expected that first stored logEntry is 'logEntry 1'", "logEntry 1", logEntries.get(0));
    Assert.assertEquals("Expected that second stored logEntry is 'logEntry 2'", "logEntry 2", logEntries.get(1));
  }

  @Test
  public void testStoredLogEntriesIsEmptyAfterReadout() {
    logEntryStorage
      .pushLine("logEntry 1")
      .pushLine("logEntry 2")
      .popAll();

    List<String> secondReadOutLogEntries = logEntryStorage.popAll();

    Assert.assertEquals("Expected that stored logEntries is empty after readout", 0, secondReadOutLogEntries.size());
  }
}
