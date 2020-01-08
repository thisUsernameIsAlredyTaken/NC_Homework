package com.example.homework.service;

import com.example.homework.repos.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InfoService {

    private final CustomerRepos customerRepos;
    private final StoreRepos storeRepos;
    private final BookRepos bookRepos;
    private final PurchaseRepos purchaseRepos;

    public List<BookRepos.BookPrice> getBookTitlePrice() {
        return bookRepos.findTitleAndPrice();
    }

    public List<String> getDistrictsWhereCustomersLive() {
        return customerRepos.getBuyersDistricts();
    }

    public List<String> getMonths() {
        return purchaseRepos.getPurchasesMonths();
    }

    public List<PurchaseRepos.CustomerLastNameStoreName> getCustomerStoreInfo() {
        return purchaseRepos.getLastNameAndStoreName();
    }

    public List<PurchaseRepos.DateLastNameDiscountTitleAmount> getInfo() {
        return purchaseRepos.getInfo();
    }
}
