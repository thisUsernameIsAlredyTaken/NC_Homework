package com.example.homework.service.crud;

import com.example.homework.entity.Customer;
import com.example.homework.repos.CustomerRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepos customerRepos;

    // CRUD
    public boolean addCustomer(Customer customer) {
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

    public Customer findCustomerById(long customerId) {
        if (customerId < 0) {
            return null;
        }
        return customerRepos.findById(customerId).orElse(null);
    }

    public boolean updateCustomer(Customer customer) {
        if (customer == null || customer.getId() == null) {
            return false;
        }
        if (!isExist(customer.getId())) {
            return false;
        }
        customerRepos.save(customer);
        return true;
    }

    public boolean deleteCustomerById(long customerId) {
        if (customerId < 0) {
            return false;
        }
        if (!isExist(customerId)) {
            return false;
        }
        customerRepos.deleteById(customerId);
        return true;
    }
    //

    private boolean isExist(long id) {
        if (id < 0) {
            return false;
        }
        return customerRepos.existsById(id);
    }

    public List<Customer> findAll() {
        return customerRepos.findAll();
    }

    public boolean patchById(long id, String lastName,
                             String district, Double commission) {
        Customer customer = findCustomerById(id);
        if (customer == null) {
            return false;
        }
        if (lastName != null) {
            customer.setLastName(lastName);
        }
        if (district != null) {
            customer.setDistrict(district);
        }
        if (commission != null) {
            customer.setCommission(commission);
        }
        customerRepos.save(customer);
        return true;
    }
}
