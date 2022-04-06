package com.trainingapps.stockapp.stockms.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;
import com.trainingapps.stockapp.stockms.exceptions.InvalidUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.NotEnoughUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;

@Validated
public interface IStockService {
	
	StockDetails addStock(@Valid AddStockRequest request)throws InvalidUnitsException;
    StockDetails findStockDetailsById(@Min(1)Long id) throws StockNotFoundException;
	StockDetails increaseQuantity(@Min(1)Long id,int newUnits) throws InvalidUnitsException,StockNotFoundException;
	Stock findById(@Min(1)Long id)throws StockNotFoundException;
	StockDetails decreaseQuantity(@Min(1)Long id,int units) throws InvalidUnitsException,StockNotFoundException,NotEnoughUnitsException;

}
