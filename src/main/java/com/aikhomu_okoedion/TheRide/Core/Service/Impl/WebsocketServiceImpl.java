package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

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
import org.springframework.kafka.annotation.KafkaListener;
import javax.websocket.*;
import org.springframework.stereotype.Service;

@Service
public class WebsocketServiceImpl implements IWebsocketService {

    IMessagePort messenger;

    GeolocationRepository geolocationRepository;

    private Session session;



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
    @KafkaListener(topics = "accepted")
    public void sendAcceptanceToCustomer(Ride ride) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(ride);
            System.out.println("====== Kafka Accepted topic listener in websocket service triggered with ===== " + json);
            this.session.getAsyncRemote().sendText(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


    @Override
    public void setSession(Session session) {
        this.session = session;
    }


}
