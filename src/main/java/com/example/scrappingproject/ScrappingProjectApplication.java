package com.example.scrappingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScrappingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrappingProjectApplication.class, args);
    }

}
