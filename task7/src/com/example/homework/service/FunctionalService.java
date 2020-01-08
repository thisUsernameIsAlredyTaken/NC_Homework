package com.example.homework.service;

import com.example.homework.repos.BookRepos;
import com.example.homework.repos.CustomerRepos;
import com.example.homework.repos.PurchaseRepos;
import com.example.homework.repos.StoreRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class FunctionalService {

    private final CustomerRepos customerRepos;
    private final StoreRepos storeRepos;
    private final BookRepos bookRepos;
    private final PurchaseRepos purchaseRepos;

    public List<CustomerRepos.CustomerLastNameDiscount> getCustomersInfo(String district) {
        return customerRepos.getLastNameAndDiscountByDistrict(district);
    }

    public List<String> getStoreNamesInDistricts(Collection<String> districts) {
        return storeRepos.findStoreNamesInDistricts(districts);
    }

    public List<BookRepos.BookPrice> getBookInfoByTitleAndPrice(String title, double price) {
        return bookRepos.findTitleAndPriceByTitleLikeOrPriceGreaterThan(
                "%" + title + "%",
                price
        );
    }
}
