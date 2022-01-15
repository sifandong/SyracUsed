package com.sifan.mp_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class MpApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpApiApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
