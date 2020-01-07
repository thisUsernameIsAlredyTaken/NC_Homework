package com.example.homework.repos;

import com.example.homework.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepos extends JpaRepository<Customer, Long> {
}
