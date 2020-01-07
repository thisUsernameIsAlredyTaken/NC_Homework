package com.example.homework.controller;

import com.example.homework.entity.Customer;
import com.example.homework.service.crud.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    // CRUD
    @PostMapping
    public void addCustomer(@RequestBody Customer customer,
                            HttpServletResponse response) {
        if (customerService.add(customer)) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable long id,
                                     HttpServletResponse response) {
        Customer foundedCustomer = customerService.findById(id);
        if (foundedCustomer == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return foundedCustomer;
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable long id,
                               @RequestBody Customer customer,
                               HttpServletResponse response) {
        if (customer.getId() != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return;
        }
        customer.setId(id);
        if (customerService.update(customer)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable long id,
                               HttpServletResponse response) {
        if (customerService.deleteById(id)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
    //

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    @PatchMapping("{id}")
    public void patchCustomer(@PathVariable long id,
                              @RequestParam(required = false) String surname,
                              @RequestParam(required = false) String district,
                              @RequestParam(required = false) Double commission,
                              HttpServletResponse response) {
        if (customerService.patchById(id, surname, district, commission)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
