package com.trainingapps.stockapp.suppliedstockms.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
import com.trainingapps.stockapp.suppliedstockms.repository.ISuppliedStockRepository;
import com.trainingapps.stockapp.suppliedstockms.util.DateUtil;
import com.trainingapps.stockapp.suppliedstockms.util.SuppliedStockUtil;

@Service
public class SuppliedStockServiceImpl implements ISuppliedStockService {

	@Autowired
	private SuppliedStockUtil suppliedStockutil;
	@Autowired
	private DateUtil dateUtil;
	@Autowired
	private ISuppliedStockRepository repository;

	@Override
	public SuppliedStockDetails add(AddSupplyStockRequest request) {

		SuppliedStock suppliedStock = new SuppliedStock();
		// suppliedStock.setId(request.getId());
		suppliedStock.setStockId(request.getStockId());
		suppliedStock.setSupplierId(request.getSupplierId());
		LocalDate date = dateUtil.convertToDate(request.getSuppliedDate());
		suppliedStock.setSuppliedDate(date);
		suppliedStock.setSuppliedCost(request.getSuppliedCost());
		suppliedStock.setUnits(request.getUnits());
		suppliedStock = repository.save(suppliedStock);
		SuppliedStockDetails details = suppliedStockutil.toSuppliedStockDetails(suppliedStock);
		return details;
	}

	@Override
	public SuppliedStockDetails findSuppliedStockDetailsByStockId(Long stockId) throws SuppliedStockNotFoundException {
		Optional<SuppliedStock> optional = repository.findByStockId(stockId);
		if (!optional.isPresent()) {

			throw new SuppliedStockNotFoundException("Stock not found");
		}

		SuppliedStock stock = optional.get();
		SuppliedStockDetails desired = suppliedStockutil.toSuppliedStockDetails(stock);
		return desired;
	}

}
