package com.example.homework.controller;

import com.example.homework.repos.BookRepos;
import com.example.homework.repos.CustomerRepos;
import com.example.homework.service.FunctionalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
@AllArgsConstructor
public class FunctionController {

    private final FunctionalService functionalService;

    @GetMapping("customer-discount")
    public List<CustomerRepos.CustomerLastNameDiscount> getCustomerDiscounts(
            @RequestParam String district) {
        return functionalService.getCustomersInfo(district);
    }

    @GetMapping("stores")
    public List<String> getStoreNames(@RequestParam List<String> districts) {
        return functionalService.getStoreNamesInDistricts(districts);
    }

    @GetMapping("book-price-by-title-price")
    public List<BookRepos.BookPrice> getBookInfo(@RequestParam String pattern,
                                                 @RequestParam double price) {
        return functionalService.getBookInfoByTitleAndPrice(pattern, price);
    }
}
