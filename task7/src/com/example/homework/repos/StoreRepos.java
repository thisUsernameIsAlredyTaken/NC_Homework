package com.example.homework.repos;

import com.example.homework.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepos extends JpaRepository<Store, Long> {
}
