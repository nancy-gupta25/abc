package com.trainingapps.stockapp.orderms.repository;

import com.trainingapps.stockapp.orderms.constant.AvailabilityStatus;
import com.trainingapps.stockapp.orderms.entity.CreatedOrder;
import com.trainingapps.stockapp.orderms.entity.OrderStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderStockRepository extends JpaRepository<OrderStock,Long> {


}
