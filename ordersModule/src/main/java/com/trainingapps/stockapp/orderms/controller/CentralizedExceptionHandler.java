package com.trainingapps.stockapp.orderms.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.stockapp.orderms.exceptions.InvalidAvailabilityStatusException;
import com.trainingapps.stockapp.orderms.exceptions.OrderNotFoundException;
import com.trainingapps.stockapp.orderms.exceptions.StockNotFoundException;

@Component
@RestController
public class CentralizedExceptionHandler {
	@ExceptionHandler(value = {
            InvalidAvailabilityStatusException.class,
            OrderNotFoundException.class,
            StockNotFoundException.class
    })

    public String handleException(Exception e) {
        return e.getMessage();
    }
}
