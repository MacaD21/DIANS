package com.example.filijaliibankomati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FilijaliIBankomatiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilijaliIBankomatiApplication.class, args);
    }
}
