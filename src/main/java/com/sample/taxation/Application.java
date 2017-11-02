/*
 * Copyright (c) 2016, Oracle. All rights reserved.
 */

package com.sample.taxation;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot starter class. Every Spring Boot class needs to start with @SpringBootApplication to
 * indicate that this should be run in a Spring container and wire the Spring Boot services to the
 * container.
 */
@SpringBootApplication
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
  private final CountDownLatch shutdownLatch = new CountDownLatch(1);

  // Spring-injection targets
  private final String appName;

  
  /**
   * Injection constructor.
   *
   * @param applicationName Spring should inject the application name here.
   */
  public Application(@Value("${spring.application.name}") final String applicationName) {    
    LOGGER.info("Starting up the {} application", applicationName);
    this.appName = applicationName;
  }   
 
  
  /**
   * The application entry point.
   *
   * @param args the command line arguments.
   * @throws InterruptedException thrown in case there is an unexpected unchecked exception to get
   *         handled by the JVM.
   */
  public static void main(final String[] args) throws InterruptedException {
    try (final ConfigurableApplicationContext applicationContext =
        SpringApplication.run(Application.class, args)) {
      /*
       * This try-with block is intended to avoid the bad practice of having an un-closed
       * auto-closable which SpringApplication#run returns. It is just necessary that this block is
       * not left before the application is requested to shut down as then the returned Spring
       * application context is closes which stops all non-daemon threads and then the application
       * would quit right away.
       *
       * This is why there is the CountDownLatch in this class that allows us to explicitly control
       * leaving the code block to trigger a graceful application shutdown.
       */
      final Application theRunningApplication = applicationContext.getBean(Application.class);
      theRunningApplication.awaitShutdownSignal();
    }
  }

  /**
   * Blocks the main thread on a {@link CountDownLatch}. The latch can be set to 0 by calling
   * {@link #shutdown()}.
   *
   * @throws InterruptedException thrown in case of an interrupt on the latch
   */
  private void awaitShutdownSignal() throws InterruptedException {
    LOGGER.info("The Spring context of application {} has successfully started", appName);
    getShutdownLatch().await();
  }

  /**
   * Notifies the Application instance to perform a shutdown by closing the Spring
   * context and letting the main thread terminate. There is no forceful shutdown attempted, so the
   * application will not exit unless all non-daemon threads have terminated.
   */
  @SuppressWarnings("unused")
  public void shutdown() {
    LOGGER.info("Shutting down the {} application", getAppName());
    getShutdownLatch().countDown();
  }

  private String getAppName() {
    return appName;
  }

  private CountDownLatch getShutdownLatch() {
    return shutdownLatch;
  }
}