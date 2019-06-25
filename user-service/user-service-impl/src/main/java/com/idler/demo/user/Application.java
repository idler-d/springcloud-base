package com.idler.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.idler.demo.user.mapper")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
