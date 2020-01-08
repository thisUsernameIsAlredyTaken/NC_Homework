package com.example.homework.service.crud;

import com.example.homework.entity.Book;
import com.example.homework.entity.Customer;
import com.example.homework.entity.Purchase;
import com.example.homework.entity.Store;
import com.example.homework.repos.PurchaseRepos;
import lombok.AllArgsConstructor;
import org.hibernate.type.DateType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepos purchaseRepos;
    private final CustomerService customerService;
    private final StoreService storeService;
    private final BookService bookService;

    public boolean add(Purchase purchase) {
        if (purchase == null || purchase.getOrderNumber() != null) {
            return false;
        }
        purchaseRepos.save(purchase);
        return true;
    }

    public Purchase findByOrderNumber(long orderNumber) {
        if (orderNumber < 1) {
            return null;
        }
        return purchaseRepos.findById(orderNumber).orElse(null);
    }

    public boolean update(Purchase purchase) {
        if (purchase == null || purchase.getOrderNumber() == null) {
            return false;
        }
        if (!isExist(purchase.getOrderNumber())) {
            return false;
        }
        purchaseRepos.save(purchase);
        return true;
    }

    public boolean deleteByOrderNumber(long orderNumber) {
        if (!isExist(orderNumber)) {
            return false;
        }
        purchaseRepos.deleteById(orderNumber);
        return true;
    }

    public List<Purchase> findAll() {
        return purchaseRepos.findAll();
    }

    private boolean isExist(long orderNumber) {
        if (orderNumber < 1) {
            return false;
        }
        return purchaseRepos.existsById(orderNumber);
    }

    public boolean patchByOrderNumber(long orderNumber, Date date,
                                      Long sellerId, Long buyerId,
                                      Long bookId, Integer amount,
                                      Double cost) {
        Purchase purchase = findByOrderNumber(orderNumber);
        if (purchase == null) {
            return false;
        }

        AtomicBoolean flag = new AtomicBoolean(false);

        Optional.ofNullable(sellerId).ifPresent(aLong -> {
            Store seller = storeService.findById(aLong);
            if (seller == null) {
                flag.set(true);
                return;
            }
            purchase.setSeller(seller);
        });
        if (flag.get()) return false;

        Optional.ofNullable(buyerId).ifPresent(aLong -> {
            Customer buyer = customerService.findById(aLong);
            if (buyer == null) {
                flag.set(true);
                return;
            }
            purchase.setBuyer(buyer);
        });
        if (flag.get()) return false;

        Optional.ofNullable(bookId).ifPresent(aLong -> {
            Book book = bookService.findById(aLong);
            if (book == null) {
                flag.set(true);
                return;
            }
            purchase.setBook(book);
        });
        if (flag.get()) return false;

        Optional.ofNullable(date).ifPresent(purchase::setDate);
        Optional.ofNullable(amount).ifPresent(purchase::setAmount);
        Optional.ofNullable(cost).ifPresent(purchase::setCost);

        purchaseRepos.save(purchase);
        return true;
    }
}
