package com.example.homework.controller;

import com.example.homework.model.User;
import com.example.homework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/from_file")
    public String createUsersFromFile(@RequestBody String data,
                                      HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        if (!userService.addNewUsersFromString(data)) {
            System.out.println("Error while saving: " + data);
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return "index";
    }

    @GetMapping
    public String findUser(@RequestParam String firstName, @RequestParam String lastName,
                           Map<String, Object> model,
                           HttpServletResponse response) {
        List<User> users = userService.findUser(firstName, lastName);

        if (users.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            model.put("message", "User not found");
            model.put("error", "Not found");
            model.put("status", "" + HttpServletResponse.SC_NOT_FOUND);
            return "error";
        } else {
            model.put("users", users);
        }
        return "user/info";
    }
}
