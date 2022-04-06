package com.trainingapps.stockapp.stockms.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;
import com.trainingapps.stockapp.stockms.exceptions.InvalidUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.NotEnoughUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;
import com.trainingapps.stockapp.stockms.repository.IStockRepository;
import com.trainingapps.stockapp.stockms.util.StockUtil;

@Transactional
@Validated
@Service
public  class StockServiceImpl implements IStockService  {
	    @Autowired
	    private IStockRepository repository;

	    @Autowired
	    private StockUtil stockUtil;
	    
	    

		@Override
		public StockDetails addStock(@Valid AddStockRequest request) throws InvalidUnitsException {
			Stock stock = new Stock();
			stock.setId(request.getId());
			stock.setStockName(request.getStockName());
			stock.setUnits(request.getUnits());
			stock.setPrice(request.getPrice());
			stock=repository.save(stock);
			
			StockDetails stockDetails=stockUtil.toStockDetails(stock);
			return stockDetails;
			
		}


		@Override
		public StockDetails findStockDetailsById(@Min(1) Long id) throws StockNotFoundException {
			Stock stock=findById(id);
			 StockDetails desired=stockUtil.toStockDetails(stock);
		        return desired;
	
		}
		@Override
		public Stock findById(@Min(1)Long id)throws StockNotFoundException{
			Optional<Stock> optional = repository.findById(id);
	        if (!optional.isPresent()) {
	            throw new StockNotFoundException("stock not found for id=" + id);
	        }
			Stock stock= optional.get();
			return(stock);
			
		}
 

		@Override
		public StockDetails increaseQuantity(@Min(1) Long id,int newUnits) throws InvalidUnitsException , StockNotFoundException{
			Stock stock=findById(id);
			int  oldUnits=stock.getUnits();
			stock.setUnits(oldUnits + newUnits);	
			StockDetails stockDetails = stockUtil.toStockDetails(stock);
			return stockDetails;
		}
		
		@Override
		public StockDetails decreaseQuantity(@Min(1) Long id,int newUnits) throws InvalidUnitsException , StockNotFoundException,NotEnoughUnitsException{
			Stock stock=findById(id);
			int  oldUnits=stock.getUnits();
			if(oldUnits<newUnits) {
				throw new NotEnoughUnitsException("Not Enough Units");
			}
			stock.setUnits(oldUnits - newUnits);	
			StockDetails stockDetails = stockUtil.toStockDetails(stock);
			return stockDetails;
		}

		



}
