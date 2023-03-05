package com.safemtech.conveniencefeeservice.controller;

import com.safemtech.conveniencefeeservice.exception.NoSubscriptionFoundException;
import com.safemtech.conveniencefeeservice.service.ConveniencefeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/conveniencefee")
public class ConveniencefeeController {

    private final ConveniencefeeService conveniencefeeService;

    public ConveniencefeeController(ConveniencefeeService conveniencefeeService) {
        this.conveniencefeeService = conveniencefeeService;
    }

    /**
     *
     * @param customerId required request parametes
     * @throws NoSubscriptionFoundException if customer is not subscribed to requested service
     * @return calculated fee based on customer defined rules
     */
    @GetMapping("/calculate")
    @Operation(summary = "Use customer id to fetch rules and calculate convenience fee")
    public BigDecimal calculateConveniceFee(@RequestParam Long customerId) throws NoSubscriptionFoundException {
        return conveniencefeeService.calculateConvenienceFee(customerId);
    }
}
