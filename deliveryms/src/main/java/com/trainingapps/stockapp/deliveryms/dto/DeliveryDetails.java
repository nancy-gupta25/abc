package com.trainingapps.stockapp.deliveryms.dto;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;

import java.time.LocalDate;

public class DeliveryDetails {
    private Long orderId;
    LocalDate deliveredDate;

    private String deliveryStatus;
    public DeliveryDetails(){

    }
    public DeliveryDetails(Long orderId, LocalDate deliveredDate, String deliveryStatus) {
        this.orderId = orderId;
        this.deliveredDate = deliveredDate;
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatus(){
        return deliveryStatus;
    }
    public void setDeliveryStatus(String deliveryStatus){
        this.deliveryStatus=deliveryStatus;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }


}
