package com.example.homework.repos;

import com.example.homework.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepos extends JpaRepository<Purchase, Long> {
}
