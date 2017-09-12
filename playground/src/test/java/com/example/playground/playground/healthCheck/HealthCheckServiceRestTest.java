package com.example.playground.playground.healthCheck;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.playground.playground.BaseTest;
import com.example.playground.playground.logging.LoggableResponse;

/**
 * Created by BurggrafM on 12.09.2017.
 */
public class HealthCheckServiceRestTest extends BaseTest {

  @Autowired
  private HealthCheckServiceRest healthCheckServiceRest;

  @Test
  public void testHealthCheck() {
    LoggableResponse response = healthCheckServiceRest.healthCheck();
    Assert.assertEquals("Expected that healtheck result content is 'backend healthCheck ... OK'",
      "backend healthCheck ... OK", response.getContent());
  }
}
