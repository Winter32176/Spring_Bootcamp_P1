package com.example.demo.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController {

    @GetMapping("/error/403")
    public String forbidden() {
        return "error/403";
    }
}
