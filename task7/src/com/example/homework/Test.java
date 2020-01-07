package com.example.homework;

import com.example.homework.entity.Customer;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setLastName("Egorov");

        System.out.println("customer = " + customer);

        String surname = null;

        Optional.ofNullable(surname).ifPresent(customer::setLastName);

        System.out.println("customer = " + customer);

        surname = "Sergeev";

        Optional.ofNullable(surname).ifPresent(customer::setLastName);

        System.out.println("customer = " + customer);
    }
}
