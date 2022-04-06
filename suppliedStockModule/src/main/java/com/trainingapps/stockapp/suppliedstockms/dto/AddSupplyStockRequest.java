package com.trainingapps.stockapp.suppliedstockms.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;

public class AddSupplyStockRequest {
	@Min(1)
	long stockId;
	@Min(1)
	long supplierId;
	String suppliedDate;
	Double suppliedCost;
	@Min(1)
	int units;

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSuppliedDate() {
		return suppliedDate;
	}

	public void setSuppliedDate(String suppliedDate) {
		this.suppliedDate = suppliedDate;
	}

	public Double getSuppliedCost() {
		return suppliedCost;
	}

	public void setSuppliedCost(Double suppliedCost) {
		this.suppliedCost = suppliedCost;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}
