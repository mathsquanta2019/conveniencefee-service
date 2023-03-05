package com.safemtech.conveniencefeeservice.repository;

import com.safemtech.conveniencefeeservice.entity.Customer;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
    Optional<Customer> findCustomerByUsername(String username);
}
