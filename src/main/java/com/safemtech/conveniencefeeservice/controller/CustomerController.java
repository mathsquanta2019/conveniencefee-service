package com.safemtech.conveniencefeeservice.controller;

import com.safemtech.conveniencefeeservice.entity.Customer;
import com.safemtech.conveniencefeeservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("cfs/v1")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    /**
     *
     * @param customer required to add customer to customer database
     * @return returns customer Id
     * @throws URISyntaxException when URI is malformed. Almost will not happen.
     */
    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody @NonNull Customer customer) throws URISyntaxException {
        CompletableFuture<Customer> addCustomerFuture = CompletableFuture.supplyAsync(()->customerService.addCustomer(customer));
        Customer cust = addCustomerFuture.join();
        return ResponseEntity.created(new URI("/v1/conveniencefeeservice/addCustomer"))
                .body(cust.getId().toString());
    }

    /**
     *
     * @param id required to fetch customer
     * @return returns matching customer object
     */
    @GetMapping("/customer")
    @Cacheable(cacheNames = {"customer.management.map"}, key = "#id",unless = "#result==null")
    public Customer getCustomerById(@RequestParam(name = "id") @NonNull Long id) {
        LOGGER.info("{} retrieved from DB", id);
        CompletableFuture<Customer> customerFuture = CompletableFuture.supplyAsync(() -> customerService.getCustomerById(id));
        return customerFuture.join();
    }

}
