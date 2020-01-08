package com.example.homework.controller.crud;

import com.example.homework.entity.Purchase;
import com.example.homework.service.crud.PurchaseService;
import lombok.AllArgsConstructor;
import org.hibernate.type.DateType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public void addPurchase(@RequestBody Purchase purchase,
                            HttpServletResponse response) {
        if (purchaseService.add(purchase)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @GetMapping("{orderNumber}")
    public Purchase findPurchaseByOrderNumber(@PathVariable long orderNumber,
                                 HttpServletResponse response) {
        Purchase purchase = purchaseService.findByOrderNumber(orderNumber);
        if (purchase == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return purchase;
    }

    @PutMapping("{orderNumber}")
    public void updatePurchase(@PathVariable long orderNumber,
                           @RequestBody Purchase purchase,
                           HttpServletResponse response) {
        if (purchase.getOrderNumber() != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        purchase.setOrderNumber(orderNumber);
        if (purchaseService.update(purchase)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping("{orderNumber}")
    public void deletePurchase(@PathVariable long orderNumber,
                           HttpServletResponse response) {
        if (purchaseService.deleteByOrderNumber(orderNumber)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
    //

    @GetMapping
    public List<Purchase> findAllPurchases() {
        return purchaseService.findAll();
    }

    @PatchMapping("{orderNumber}")
    public void patchBook(@PathVariable long orderNumber,
                          @RequestParam(required = false) Date date,
                          @RequestParam(required = false) Long sellerId,
                          @RequestParam(required = false) Long buyerId,
                          @RequestParam(required = false) Long bookId,
                          @RequestParam(required = false) Integer amount,
                          @RequestParam(required = false) Double cost,
                          HttpServletResponse response) {
        if (purchaseService.patchByOrderNumber(orderNumber, date,
                sellerId, buyerId, bookId, amount, cost)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
