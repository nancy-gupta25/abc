package com.trainingapps.stockapp.deliveryms.util;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryException;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryStatusTypeException;
import org.springframework.stereotype.Component;

@Component
public class DeliveryUtil {
    public DeliveryDetails toDeliveryDetails(Delivery delivery){

        DeliveryStatus deliveryStatus=delivery.getDeliveryStatus();
        String deliveryText=deliveryStatus.toString();

        DeliveryDetails desired=new DeliveryDetails(delivery.getOrderId(),delivery.getDeliveredDate(),deliveryText);
        return desired;
    }

    public DeliveryStatus toEnum(String deliveryText) throws InvalidDeliveryStatusTypeException {
        DeliveryStatus values[] = DeliveryStatus.values();
        for (DeliveryStatus iterated : values) {
            String iteratedText = iterated.toString();
            if (iteratedText.equalsIgnoreCase(deliveryText)) {
                return iterated;
            }
        }
        throw new InvalidDeliveryStatusTypeException("Invalid") ;
    }
}
