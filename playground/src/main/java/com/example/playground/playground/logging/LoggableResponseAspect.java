package com.example.playground.playground.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by BurggrafM on 13.09.2017.
 */
@Aspect
@Component
public class LoggableResponseAspect {

  @Autowired
  private LogEntryStorage logEntryStorage;

  @Around("execution(LoggableResponse *.*(..))")
  public LoggableResponse enrichResponseWithLogEntries(ProceedingJoinPoint joinPoint) throws Throwable {
    LoggableResponse response = (LoggableResponse) joinPoint.proceed();
    return new LoggableResponse
      .LoggableResponseBuilder()
        .content(response.getContent())
        .logEntries(logEntryStorage.popAll())
        .buildResponse();
  }
}
