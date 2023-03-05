package com.safemtech.conveniencefeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableCaching
@EnableWebSecurity
public class ConveniencefeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConveniencefeeServiceApplication.class, args);
    }

}
