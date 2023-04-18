package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.GeolocationDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaMessageAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.kafka.annotation.KafkaListener;
import javax.websocket.*;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebsocketServiceImpl implements IWebsocketService {

    IMessagePort messenger;

    GeolocationRepository geolocationRepository;


    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;



    @Autowired
    public WebsocketServiceImpl(GeolocationDBAdapter geolocationDBAdapter, KafkaMessageAdapter kafkaMessageAdapter) {

        this.geolocationRepository = geolocationDBAdapter;
        this.messenger = kafkaMessageAdapter;

    }


    public WebsocketServiceImpl(GeolocationDBTestAdapter geolocationTestDBAdapter, KafkaTestAdapter kafkaTestAdapter) {

        this.geolocationRepository = geolocationTestDBAdapter;
        this.messenger = kafkaTestAdapter;

    }

    @Override
    public Geolocation forwardLocationToKafka(MessageDTO theMessage) {
        Geolocation geolocation = new Geolocation(theMessage);
       this.messenger.sendLocationToPending(geolocation);
        this.geolocationRepository.save(geolocation);
        return geolocation;
    }



    @Override
    @KafkaListener(topics = "accepted", groupId = "group1")
    public void sendAcceptanceToCustomer(Ride ride) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(ride);
            System.out.println("====== Kafka Accepted topic listener in websocket service triggered with ===== " + json);
           this.simpMessagingTemplate.convertAndSend("/accepted", ride);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    @KafkaListener(topics = "matched", groupId = "group1")
    public void sendMatchToDriver(Customer customer) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(customer);
            System.out.println("====== Kafka matched topic listener in websocket service triggered with ===== " + json);
            this.simpMessagingTemplate.convertAndSend("/matched", customer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void setSession(Session session) {

    }


}
