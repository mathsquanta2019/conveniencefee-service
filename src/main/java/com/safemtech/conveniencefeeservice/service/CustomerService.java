package com.safemtech.conveniencefeeservice.service;

import com.safemtech.conveniencefeeservice.dto.ErrorCode;
import com.safemtech.conveniencefeeservice.entity.Customer;
import com.safemtech.conveniencefeeservice.exception.CustomerNotFoundException;
import com.safemtech.conveniencefeeservice.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder encoder;


    public CustomerService(CustomerRepository customerRepository, PasswordEncoder encoder) {
        this.customerRepository = customerRepository;
        this.encoder = encoder;
    }

    public Customer addCustomer(Customer customer){
        customer.setPassword(encoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("No customer found",ErrorCode.CNF));
    }
}
