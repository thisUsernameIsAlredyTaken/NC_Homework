package com.example.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String error(@RequestParam(defaultValue = "Unknown error") String error,
                        @RequestParam(defaultValue = "500") String status,
                        @RequestParam(defaultValue = "") String message,
                        Map<String, String> model) {
        model.put("error", error);
        model.put("status", status);
        model.put("message", message);
        return "error";
    }
}
