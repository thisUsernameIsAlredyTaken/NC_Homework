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
        if (!customerService.addCustomer(customer)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else {
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable long id,
                                     HttpServletResponse response) {
        Customer foundedCustomer = customerService.findCustomerById(id);
        if (foundedCustomer == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return foundedCustomer;
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer,
                               HttpServletResponse response) {
        if (customerService.updateCustomer(customer)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable long id,
                               HttpServletResponse response) {
        if (customerService.deleteCustomerById(id)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
    //

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PatchMapping("{id}")
    public void patchCustomer(@PathVariable long id,
                              @RequestParam(defaultValue = "") String surname,
                              @RequestParam(defaultValue = "") String district,
                              @RequestParam(defaultValue = "") Double commission,
                              HttpServletResponse response) {
        if (customerService.patchById(id, surname, district, commission)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
