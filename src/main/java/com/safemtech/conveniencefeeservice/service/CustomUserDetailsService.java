package com.safemtech.conveniencefeeservice.service;


import com.safemtech.conveniencefeeservice.dto.ErrorCode;
import com.safemtech.conveniencefeeservice.entity.Customer;
import com.safemtech.conveniencefeeservice.exception.CustomerNotFoundException;
import com.safemtech.conveniencefeeservice.repository.CustomerRepository;
import com.safemtech.conveniencefeeservice.service.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findCustomerByUsername(username);
        return customer.map(CustomerDetails::new)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found", ErrorCode.CNF));

    }
}
