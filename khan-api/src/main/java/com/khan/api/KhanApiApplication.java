package com.khan.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableResourceServer
public class KhanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhanApiApplication.class, args);
    }

}
