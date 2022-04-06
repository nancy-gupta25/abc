package com.trainingapps.stockapp.suppliedstockms.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
@Validated
public interface ISuppliedStockService {
	SuppliedStockDetails add(@Valid AddSupplyStockRequest request);
	SuppliedStockDetails findSuppliedStockDetailsByStockId(@Min(1)Long stockId) throws SuppliedStockNotFoundException;
	

	

}
