package com.trainingapps.stockapp.stockms.util;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;

@Component
public class StockUtil {
	

	public StockDetails toStockDetails(@Valid Stock stock) {

        StockDetails desired = new StockDetails(stock.getId(), stock.getUnits(), stock.getStockName(),stock.getPrice());

        return desired;
	}
	
	

}
