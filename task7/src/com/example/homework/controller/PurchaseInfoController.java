package com.example.homework.controller;

import com.example.homework.repos.PurchaseRepos;
import com.example.homework.service.FunctionalService;
import com.example.homework.service.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("purchase-info")
@AllArgsConstructor
public class PurchaseInfoController {

    private final InfoService infoService;

    @GetMapping("buyer-seller")
    public List<PurchaseRepos.CustomerLastNameStoreName> getCustomerStoreInfo() {
        return infoService.getCustomerStoreInfo();
    }

    @GetMapping("date-buyer-discount-title-amount")
    public List<PurchaseRepos.DateLastNameDiscountTitleAmount> getPurchaseInfo() {
        return infoService.getInfo();
    }
}
