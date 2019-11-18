package com.khan.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.khan.api")
@EnableFeignClients
@MapperScan("com.khan.api.mapper")
public class KhanApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhanApiApplication.class, args);
    }

}
