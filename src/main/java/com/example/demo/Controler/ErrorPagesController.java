package com.example.demo.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPagesController {
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
    @GetMapping("/501")
    public String error() {
        return "501";
    }
}