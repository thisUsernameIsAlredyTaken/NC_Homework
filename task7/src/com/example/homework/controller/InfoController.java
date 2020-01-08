package com.example.homework.controller;

import com.example.homework.repos.BookRepos;
import com.example.homework.service.FunctionalService;
import com.example.homework.service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("info")
public class InfoController {

    private final FunctionalService functionalService;
    private final InfoService infoService;

    @GetMapping("book-price")
    public List<BookRepos.BookPrice> getAllBookPrice() {
        return infoService.getBookTitlePrice();
    }

    @GetMapping("buyer-districts")
    public List<String> getBuyerDistricts() {
        return infoService.getDistrictsWhereCustomersLive();
    }

    @GetMapping("purchase-months")
    public List<String> getMonths() {
        return infoService.getMonths();
    }
}
