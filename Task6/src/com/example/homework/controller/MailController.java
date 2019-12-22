package com.example.homework.controller;

import com.example.homework.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/mail")
@AllArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping
    public String write(@RequestParam(defaultValue = "") String mail,
                        Map<String, String> model) {
        model.put("mail", mail);
        return "mail_write";
    }

    @PostMapping("send")
    public String send(@RequestParam String mail, @RequestParam String message) {
        mailService.send(mail, message);
        return "index";
    }
}
