package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String id) {
        return ("Hello, Spring Boot! + Your ID is: " + id);
    }
}
