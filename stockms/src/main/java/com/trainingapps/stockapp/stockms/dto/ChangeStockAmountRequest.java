package com.trainingapps.stockapp.stockms.dto;

import javax.validation.constraints.NotBlank;

public class ChangeStockAmountRequest {
	
	private Long id;
	@NotBlank
	private int units;
	
	public int getUnits() {
		return units;
	}
	
	public void setUnits(int units) {
		this.units=units;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
