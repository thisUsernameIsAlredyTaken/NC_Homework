package com.example.homework.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String thirdName;

    @NonNull
    private int age;

    @NonNull
    private int salary;

    @NonNull
    private String mail;

    @NonNull
    private String workPlace;
}
