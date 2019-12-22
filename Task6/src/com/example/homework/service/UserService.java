package com.example.homework.service;

import com.example.homework.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class UserService {

//    private final FileService fileService;
    private final String separator = "-~-";

    public boolean addNewUser(User user) {
        if (!validateUser(user)) {
            return false;
        }
        String newUserData = userToString(user);
        try (FileWriter file = new FileWriter("./resources/data.csv", true)) {
            file.write(newUserData + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addNewUsers(List<User> users) {
        boolean allAdded = true;
        for (User user : users) {
            if (!addNewUser(user)) {
                allAdded = false;
            }
        }
        return allAdded;
    }

    public List<User> findUser(String firstName, String lastName) {
        List<User> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("./resources/data.csv"))) {
            while (scanner.hasNextLine()) {
                User user = userFromString(scanner.nextLine());
                if (firstName.toLowerCase().equals(user.getFirstName().toLowerCase()) &&
                        lastName.toLowerCase().equals(user.getLastName().toLowerCase())) {
                    result.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return result;
    }

    public boolean addNewUsersFromFile(MultipartFile file) {
//        fileService.uploadFile(file);
        boolean added = false;
        try (
                Scanner scanner = new Scanner(file.getInputStream())
                ) {
            while (scanner.hasNextLine()) {
                User user = userFromString(scanner.nextLine());
                if (addNewUser(user)) {
                    added = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return added;
    }

    private String userToString(User user) {
        return user.getFirstName() + separator +
                user.getLastName() + separator +
                user.getThirdName() + separator +
                user.getAge() + separator +
                user.getSalary() + separator +
                user.getMail() + separator +
                user.getWorkPlace();
    }

    private User userFromString(String userData) {
        String[] data = userData.split(separator);
        if (data.length == 6) {
            String[] tmp = new String[7];
            for (int i = 0; i < data.length; i++) {
                tmp[i] = data[i];
            }
            tmp[6] = "";
            data = tmp;
        }
        if (data.length != 7) {
            return null;
        }
        return new User(data[0], data[1], data[2],
                Integer.parseInt(data[3]),
                Integer.parseInt(data[4]), data[5], data[6]);
    }

    private boolean validateUser(User user) {
        if (user == null) {
            return false;
        }
        if (!user.getMail().matches(".+@.+\\..+")) {
            return false;
        }
        if (user.getAge() < 13 || user.getSalary() < 0) {
            return false;
        }
        if (user.getFirstName().length() < 1 ||
                user.getLastName().length() < 1) {
            return false;
        }
        return true;
    }
}
