package com.idler.demo.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "demo")
@Data
public class AuthProperties {

  private String cookieName;
  private Integer cookieMaxAge;
}
