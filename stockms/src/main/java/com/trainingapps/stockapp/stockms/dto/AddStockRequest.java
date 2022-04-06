package com.trainingapps.stockapp.stockms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddStockRequest {

	@Min(1)
	private Long id;
	@NotBlank
	private String stockName;
	private int units;
	private double price;
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public  Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
		
	}
	
	


	
}
