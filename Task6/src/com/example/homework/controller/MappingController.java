package com.example.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MappingController {

    @GetMapping
    public String homePage() {
        return "index";
    }

    @GetMapping("user/create")
    public String createUser() {
        return "user/create";
    }

    @GetMapping("user/not_found")
    public String userNotFound() {
        return "user/not_found";
    }

    @GetMapping("user/info")
    public String userInfo() {
        return "user/info";
    }

    @GetMapping("user/find")
    public String readUser() {
        return "user/find";
    }
}
