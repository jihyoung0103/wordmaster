package com.smu.wordmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WordmasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordmasterApplication.class, args);
    }

}
