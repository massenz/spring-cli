package com.alertavert.constructs.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <h3>ApplicationProperties</h3>
 *
 * @author M. Massenzio, 2021-10-28
 */
@ConfigurationProperties(prefix = "datastore")
@Data
public class ApplicationProperties {

  String host;
  int port;
  String databaseName;
}
