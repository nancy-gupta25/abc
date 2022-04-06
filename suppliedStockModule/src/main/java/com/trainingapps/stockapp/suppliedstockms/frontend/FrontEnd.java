package com.trainingapps.stockapp.suppliedstockms.frontend;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.service.ISuppliedStockService;

@Component
public class FrontEnd {

	@Autowired
	private ISuppliedStockService service;

	public void runUI() {
		try {
			System.out.println("***adding supplied Stock****");
			AddSupplyStockRequest requestData1 = new AddSupplyStockRequest();
			//LocalDate date = LocalDate.now();
			
		//	requestData1.setId((long) 1);
			requestData1.setStockId((long) 7);
			requestData1.setSupplierId((long) 3);
			requestData1.setSuppliedDate("06-04-2022");
			requestData1.setUnits(5);
			requestData1.setSuppliedCost(50000.0);
			
			
			SuppliedStockDetails suppliedStock1 = service.add(requestData1);
			
			AddSupplyStockRequest requestData2 = new AddSupplyStockRequest();
			
			
		//	requestData2.setId((long) 2);
			requestData2.setStockId((long) 3);
			requestData2.setSupplierId((long) 4);
			requestData2.setSuppliedDate("06-04-2022");
			requestData2.setUnits(5);
			requestData2.setSuppliedCost(10000.0);
			
			
			SuppliedStockDetails suppliedStock2 = service.add(requestData2);
			
			AddSupplyStockRequest requestData3 = new AddSupplyStockRequest();
			
			
			//	requestData3.setId((long) 2);
				requestData3.setStockId((long) 2);
				requestData3.setSupplierId((long) 2);
				requestData3.setSuppliedDate("06-04-2022");
				requestData3.setUnits(5);
				requestData3.setSuppliedCost(8000.0);
				
				
				SuppliedStockDetails suppliedStock3 = service.add(requestData3);
				
			
			System.out.println("***Displaying the record****");
			display(suppliedStock1);
			display(suppliedStock2);
			display(suppliedStock3);
			System.out.println("**Find by Stock ID****");
			suppliedStock1 = service.findSuppliedStockDetailsByStockId((long)2);
			display(suppliedStock1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	void display(SuppliedStockDetails supplyStock) {
		System.out.println(supplyStock.getId() + " - " + supplyStock.getStockId() + " - " + supplyStock.getSupplierId()
				+ " - " + supplyStock.getSuppliedDate() + " - " + supplyStock.getUnits() + " - "
				+ supplyStock.getSuppliedCost());
	}
}
