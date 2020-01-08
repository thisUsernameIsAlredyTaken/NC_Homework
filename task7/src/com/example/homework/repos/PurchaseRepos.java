package com.example.homework.repos;

import com.example.homework.entity.Purchase;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

public interface PurchaseRepos extends JpaRepository<Purchase, Long> {

    interface CustomerLastNameStoreName {
        @Value("#{target.buyer.lastName}")
        String getLastName();

        @Value("#{target.seller.name}")
        String getName();
    }

    interface DateLastNameDiscountTitleAmount {
        Date getDate();

        @Value("#{target.buyer.lastName}")
        String getLastName();

        @Value("#{target.seller.district}")
        String getDistrict();

        @Value("#{target.book.title}")
        String getTitle();

        int getAmount();
    }

    @Query(nativeQuery = true,
            value = "select distinct to_char(p.date, 'Month') from purchase p")
    List<String> getPurchasesMonths();

    @Query("select p from Purchase p")
    List<CustomerLastNameStoreName> getLastNameAndStoreName();

    @Query("select p from Purchase p")
    List<DateLastNameDiscountTitleAmount> getInfo();
}
