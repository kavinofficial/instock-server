package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.repository.CustomerRepo;
import com.aspirecoders.instock.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(int id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepo.findById(id);

        if (existingCustomer.isEmpty()) {
            return null;
        }

        Customer cust = existingCustomer.get();
        cust.setCustomerName(customer.getCustomerName());
        cust.setMobile(customer.getMobile());
        return customerRepo.save(cust);
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

}
