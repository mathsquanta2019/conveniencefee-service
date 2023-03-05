package com.safemtech.conveniencefeeservice.service;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.safemtech.conveniencefeeservice.entity.Customer;
import com.safemtech.conveniencefeeservice.exception.NoSubscriptionFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Service class for calculating convenience fee based on defined rules.
 * Customers must be subscribed to this service and a customer can only define a max of 10 rules.
 */
@Service
public class ConveniencefeeService {

    IMap<String, Object> rulesMap;
    IMap<String, Object> subscriptionMap;
    IMap<Long, Customer> customerManagementMap;

    public ConveniencefeeService(HazelcastInstance hazelcastInstance) {
        hazelcastInstance.getConfig().setClusterName("cfs.cluster");
        rulesMap = hazelcastInstance.getMap("convenience.rules.map");
        subscriptionMap = hazelcastInstance.getMap("subscription.service.map");
        customerManagementMap = hazelcastInstance.getMap("customer.management.map");
    }


    public BigDecimal calculateConvenienceFee(Long customerId) throws NoSubscriptionFoundException {
        /*First get subscriptions from Cache/subscription service API. If empty, reject
         if available, validate that customer is eligible. Reject if not eligible
         If eligible, call customerManagementService, rules service and Binlookup service concurrently
         Combine the results and trigger the rule engine to determine fee.

         */

        return new BigDecimal("198.34");
    }
}
