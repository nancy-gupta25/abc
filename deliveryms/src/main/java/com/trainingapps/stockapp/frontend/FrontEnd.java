package com.trainingapps.stockapp.frontend;



import com.trainingapps.stockapp.deliveryms.dto.AddDeliveryRequest;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.service.IDeliveryService;
import com.trainingapps.stockapp.deliveryms.service.IDeliveryServiceImpl;
import com.trainingapps.stockapp.deliveryms.util.DeliveryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrontEnd {

    @Autowired
    IDeliveryService service;

    @Autowired
    DeliveryUtil util;

    public void runUI(){

        try{

            System.out.println("adding job in the list and these are as follows:");

            /*--------------------adding 1st job---------------------------*/

            AddDeliveryRequest request1 = new AddDeliveryRequest();
            request1.setOrderId(201L);
            request1.setDeliveryStatusType("Dispatched");

            DeliveryDetails delivery1 = service.add(request1);
            System.out.println("delivery 1 added successfully with the below details");
            display(delivery1);



            /*-----------------------------------------finding student by id--------------------------------------*/


            long orderId1 = delivery1.getOrderId();
            Delivery found=service.findDeliveryDetailsbyId(orderId1);
            DeliveryDetails response=util.toDeliveryDetails(found);
            System.out.println("Finding delivery by id "+orderId1);
            display(response);





        }catch (Exception e){

            e.printStackTrace();

        }
     }

     void display(DeliveryDetails details){

         System.out.println("id : "+ details.getOrderId() +"Delivered Date : " +details.getDeliveredDate()+"Delivery Status : "+details.getDeliveryStatus());

     }


}
