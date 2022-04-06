package com.trainingapps.stockapp.suppliedstockms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
import com.trainingapps.stockapp.suppliedstockms.service.ISuppliedStockService;

@RequestMapping("/suppliedstock")
@RestController
public class SuppliedStockController {
	
	   @Autowired
	    private ISuppliedStockService service;
	   @PostMapping("/add")
	    public SuppliedStockDetails addSuppliedStock(@RequestBody AddSupplyStockRequest request) {
	          return service.add(request);
	    }
	   
	   @GetMapping("/findByStockId/{id}")
	   public SuppliedStockDetails findStockById(@PathVariable long id) throws SuppliedStockNotFoundException {
		   SuppliedStockDetails response = service.findSuppliedStockDetailsByStockId(id);
	        return response;
	   }

	
}
