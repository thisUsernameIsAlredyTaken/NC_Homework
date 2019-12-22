package com.example.homework.service;

import com.example.homework.model.User;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private final String separator = "-~-";

    public boolean addNewUser(User user) {
        if (!validateUser(user)) {
            return false;
        }
        try (FileWriter file = new FileWriter("./resources/data.csv", true)) {
            String newUserData = userToString(user);
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

    private boolean findMail(String email) {
        try (Scanner scanner = new Scanner(new File("./resources/data.csv"))) {
            while (scanner.hasNextLine()) {
                User user = userFromString(scanner.nextLine());
                if (email.equals(user.getMail())) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public boolean addNewUsersFromString(String data) {
        Scanner scanner = new Scanner(data);
        while (scanner.hasNextLine()) {
            User user = userFromString(scanner.nextLine());
            addNewUser(user);
        }
        scanner.close();
        return true;
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
        if (!user.getMail().matches(".+@.+\\..+") ||
                findMail(user.getMail())) {
            return false;
        }
        if (user.getAge() < 13 || user.getSalary() < 0) {
            return false;
        }
        return true;
    }
}
