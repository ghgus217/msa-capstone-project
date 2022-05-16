package onlineshop.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;

import onlineshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import onlineshop.domain.*;


@Service
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_DeliveryCancelled(@Payload OrderCancelled orderCancelled){

        if(!orderCancelled.validate()) return;
        OrderCancelled event = orderCancelled;
        System.out.println("\n\n##### listener DeliveryCancelled : " + orderCancelled.toJson() + "\n\n");


        

        // Sample Logic //
        Delivery.deliveryCancelled(event);
        

        

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_DeliveryStarted(@Payload Ordered ordered){

        if(!ordered.validate()) return;
        Ordered event = ordered;
        System.out.println("\n\n##### listener DeliveryStarted : " + ordered.toJson() + "\n\n");


        

        // Sample Logic //
        Delivery.deliveryStarted(event);
        

        

    }


}


