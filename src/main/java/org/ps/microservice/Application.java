package org.ps.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.ps.microservice")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}