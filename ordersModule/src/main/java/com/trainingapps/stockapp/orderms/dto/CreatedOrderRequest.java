package com.trainingapps.stockapp.orderms.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;


public class CreatedOrderRequest {
    @NotEmpty
    private List<StockRequest> stocksRequest;

    public List<StockRequest> getStocksRequest() {
        return stocksRequest;
    }

    public void setStocksRequest(List<StockRequest> stocksRequest) {
        this.stocksRequest = stocksRequest;
    }
}
