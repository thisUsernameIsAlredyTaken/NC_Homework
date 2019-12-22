package com.example.homework.controller;

import com.example.homework.model.User;
import com.example.homework.service.UserService;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createUser(@ModelAttribute User user,
                             HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        if (!userService.addNewUser(user)) {
            System.out.println("Error while saving: " + user);
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return "index";
    }

    @PostMapping("from_file")
    public String createUsersFromFile(@RequestParam("file") MultipartFile file,
                                      HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        if (!userService.addNewUsersFromFile(file)) {
            System.out.println("Error while saving: " + file);
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return "index";
    }

    @GetMapping
    public String findUser(@RequestParam String firstName, @RequestParam String lastName,
                           Map<String, Object> model,
                           HttpServletResponse response,
                           HttpServletRequest request) {
        List<User> users = userService.findUser(firstName, lastName);

        if (users.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            model.put("message", "User not found");
            model.put("error", "Not found");
            model.put("status", "" + HttpServletResponse.SC_NOT_FOUND);
            return "error";
        } else {
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
//            System.out.println(userAgent.getBrowser());
//            System.out.println(userAgent.getOperatingSystem());
            model.put("browser", userAgent.getBrowser());
            model.put("time", new Date().toString());
            model.put("users", users);
        }
        return "user/info";
    }
}
