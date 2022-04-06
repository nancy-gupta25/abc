package com.trainingapps.stockapp.deliveryms.repository;

import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryRepository extends JpaRepository<Delivery,Long> {

}
