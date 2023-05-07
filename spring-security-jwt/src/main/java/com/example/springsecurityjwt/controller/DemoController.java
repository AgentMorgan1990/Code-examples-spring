package com.example.springsecurityjwt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/demo")
    public String getDemoInfo() {
        return "Secured Demo Info";
    }

    @GetMapping("/user")
    public String getDemoInfoUser() {
        return "Unsecured Demo Info";
    }
}
