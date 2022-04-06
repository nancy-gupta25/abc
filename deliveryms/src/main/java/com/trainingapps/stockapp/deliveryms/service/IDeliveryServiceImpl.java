package com.trainingapps.stockapp.deliveryms.service;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.AddDeliveryRequest;
import com.trainingapps.stockapp.deliveryms.dto.ChangeDeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.exceptions.DeliveryOrderNotFoundException;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryStatusTypeException;
import com.trainingapps.stockapp.deliveryms.repository.IDeliveryRepository;
import com.trainingapps.stockapp.deliveryms.util.DeliveryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class IDeliveryServiceImpl implements IDeliveryService {
    @Autowired
    private IDeliveryRepository repository;
    @Autowired
    private IDeliveryService deliveryService;
    @Autowired
    private DeliveryUtil deliveryUtil;

    @Override
    public DeliveryDetails add(AddDeliveryRequest request) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(request.getOrderId());
        delivery=repository.save(delivery);
        DeliveryDetails desired = deliveryUtil.toDeliveryDetails(delivery);
        return desired;
    }
    @Override
    public Delivery findDeliveryDetailsbyId(Long id)throws DeliveryOrderNotFoundException{
        Optional<Delivery> optional=repository.findById(id);
        if (!optional.isPresent()) {
            throw new DeliveryOrderNotFoundException("delivery not found");
        }

        Delivery delivery = optional.get();
        return delivery;

    }
    @Override
    public DeliveryDetails changeDeliveryStatus(ChangeDeliveryStatus request)throws InvalidDeliveryStatusTypeException,DeliveryOrderNotFoundException {
        Delivery delivery = findDeliveryDetailsbyId(request.getOrderId());
        String newDeliveryStatus = request.getDeliveryStatus();
        DeliveryStatus deliveryStatus = deliveryUtil.toEnum(newDeliveryStatus);
        delivery.setDeliveryStatus(deliveryStatus);
        delivery = repository.save(delivery);
        DeliveryDetails response = deliveryUtil.toDeliveryDetails(delivery);
        return response;
    }

}
