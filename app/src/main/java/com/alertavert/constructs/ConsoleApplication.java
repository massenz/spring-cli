package com.alertavert.constructs;

import com.alertavert.constructs.configuration.ApplicationConfiguration;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <h3>ConsoleApplication</h3>
 *
 * @author M. Massenzio, 2021-10-27
 */
@Component
@Log
public class ConsoleApplication {

  @Autowired
  String dbUri;

  @Autowired
  int clusterSize;

  @PostConstruct
  public void execute() {
    log.info("Connecting to: " + dbUri);
    log.info("Running size: " + clusterSize);
  }
}
