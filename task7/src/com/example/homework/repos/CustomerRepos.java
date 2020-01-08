package com.example.homework.repos;

import com.example.homework.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepos extends JpaRepository<Customer, Long> {

    interface CustomerLastNameDiscount {
        String getLastName();
        double getDiscount();
    }

    @Query("select distinct c.district from Customer c")
    List<String> getBuyersDistricts();

    @Query("select c from Customer c where c.district like :district")
    List<CustomerLastNameDiscount> getLastNameAndDiscountByDistrict(@Param("district") String district);
}
