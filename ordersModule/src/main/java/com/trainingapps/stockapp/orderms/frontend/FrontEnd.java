package com.trainingapps.stockapp.orderms.frontend;

import com.trainingapps.stockapp.orderms.dto.CreatedOrderRequest;
import com.trainingapps.stockapp.orderms.dto.OrderDetails;
import com.trainingapps.stockapp.orderms.dto.StockRequest;
import com.trainingapps.stockapp.orderms.service.ICreatedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class FrontEnd {
    @Autowired
    private ICreatedOrderService orderService;

    public void runUI(){
        CreatedOrderRequest request=new CreatedOrderRequest();
        StockRequest stock1Request=new StockRequest();
        stock1Request.setStockId(1l);
        stock1Request.setOrderedUnits(2);

        StockRequest stock2Request=new StockRequest();
        stock2Request.setStockId(2l);
        stock2Request.setOrderedUnits(4);

        List<StockRequest>stocksRequest= Arrays.asList(stock1Request,stock2Request);
        request.setStocksRequest(stocksRequest);
        OrderDetails orderDetails=orderService.create(request);
        System.out.println(orderDetails);

        String startDate="01/04/2022";
        String endDate="02/05/2022";
        List<OrderDetails>ordersInperiod=orderService.findAllOrders(startDate,endDate);
        System.out.println("*******orders in period");
        System.out.println(ordersInperiod);

    }

}
