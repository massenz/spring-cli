package com.alertavert.constructs.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <h3>ApplicationConfiguration</h3>
 *
 * <p>Insert class description here...
 *
 * @author M. Massenzio, 2021-10-27
 */
@Configuration
public class ApplicationConfiguration {

  public static final int FIXED_CLUSTER_SIZE = 15;

  @Value("${cluster.size}")
  int clusterSize;

  @Autowired
  ApplicationProperties properties;

  // This is OBVIOUSLY contrived, but shows how to use Qualifier
  // to select a different bean
  @Bean @Qualifier("configured")
  public int clusterSize() {
    return clusterSize;
  }

  @Bean
  @Qualifier("fixed")
  public int fiveNodes() {
    return FIXED_CLUSTER_SIZE;
  }

  @Bean
  public String dbUri() {
    return String.format("mongodb://%s:%d/%s", properties.host,
        properties.port, properties.databaseName);
  }
}
