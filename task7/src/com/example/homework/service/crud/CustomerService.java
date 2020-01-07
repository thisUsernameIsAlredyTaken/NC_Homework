package com.example.homework.service.crud;

import com.example.homework.entity.Customer;
import com.example.homework.repos.CustomerRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepos customerRepos;

    // CRUD
    public boolean add(Customer customer) {
        if (customer == null) {
            return false;
        }
        if (customer.getId() != null) {
            if (isExist(customer.getId())) {
                return false;
            }
        }
        customerRepos.save(customer);
        return true;
    }

    public Customer findById(long id) {
        if (id < 1) {
            return null;
        }
        return customerRepos.findById(id).orElse(null);
    }

    public boolean update(Customer customer) {
        if (customer == null || customer.getId() == null) {
            return false;
        }
        if (!isExist(customer.getId())) {
            return false;
        }
        customerRepos.save(customer);
        return true;
    }

    public boolean deleteById(long id) {
        if (!isExist(id)) {
            return false;
        }
        customerRepos.deleteById(id);
        return true;
    }
    //

    private boolean isExist(long id) {
        if (id < 1) {
            return false;
        }
        return customerRepos.existsById(id);
    }

    public List<Customer> findAll() {
        return customerRepos.findAll();
    }

    public boolean patchById(long id, String lastName,
                             String district, Double discount) {
        Customer customer = findById(id);
        if (customer == null) {
            return false;
        }
        Optional.ofNullable(lastName).ifPresent(customer::setLastName);
        Optional.ofNullable(district).ifPresent(customer::setDistrict);
        Optional.ofNullable(discount).ifPresent(customer::setDiscount);
        customerRepos.save(customer);
        return true;
    }
}
