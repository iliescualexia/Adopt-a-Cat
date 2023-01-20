package com.example.adoptacat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class AdoptACatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptACatApplication.class, args);
    }

}
