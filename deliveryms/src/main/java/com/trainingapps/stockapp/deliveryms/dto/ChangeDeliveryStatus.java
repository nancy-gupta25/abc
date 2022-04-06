package com.trainingapps.stockapp.deliveryms.dto;

public class ChangeDeliveryStatus {
    private Long orderId;
    private String DeliveryStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryStatus() {
        return DeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        DeliveryStatus = deliveryStatus;
    }
}
