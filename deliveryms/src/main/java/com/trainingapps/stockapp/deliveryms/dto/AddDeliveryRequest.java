package com.trainingapps.stockapp.deliveryms.dto;

public class AddDeliveryRequest {
    private Long orderId;
    private String deliveryStatusType;
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryStatusType() {
        return deliveryStatusType;
    }

    public void setDeliveryStatusType(String deliveryStatusType) {
        this.deliveryStatusType = deliveryStatusType;
    }
}
