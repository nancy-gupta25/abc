package com.trainingapps.stockapp.stockms.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;
import com.trainingapps.stockapp.stockms.service.IStockService;

@Component
public class FrontEnd {

	@Autowired
	private IStockService service;
	 public void runUI() {
		 
		 try {
		 AddStockRequest addStockRequest1 = new AddStockRequest();
		 
		 addStockRequest1.setId((long) 1);
		 addStockRequest1.setStockName("jio");
		 addStockRequest1.setUnits(10);
		 addStockRequest1.setPrice(1000);
		 StockDetails stock1 = service.addStock(addStockRequest1);
         display(stock1);
         
         Long stockDetails1Id = stock1.getId();
         StockDetails stocks = service.findStockDetailsById(stockDetails1Id);
         display(stocks);  
         
         int newUnits =5;
         StockDetails increasedStock=service.increaseQuantity(stockDetails1Id,newUnits);
         display(increasedStock);
         
         int units =2;
         StockDetails decreaseStock=service.decreaseQuantity(stockDetails1Id,units);
         display(decreaseStock);
         
         
       
		 } catch ( Exception ex) {
			 System.err.println(ex.getMessage());
		 }
	 }
	 void display(StockDetails stock) {
	        System.out.println(stock.getId() + "-" + stock.getStockName() + "-" + stock.getPrice() +"-"+ stock.getUnits());
	    }
	 
}
