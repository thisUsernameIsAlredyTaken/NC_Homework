package com.example.homework.repos;

import com.example.homework.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StoreRepos extends JpaRepository<Store, Long> {

    @Query("select s.name from Store s where s.name in :districts")
    List<String> findStoreNamesInDistricts(@Param("districts") Collection<String> districts);
}
