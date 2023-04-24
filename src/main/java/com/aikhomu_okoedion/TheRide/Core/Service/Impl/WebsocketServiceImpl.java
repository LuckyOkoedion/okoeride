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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebsocketServiceImpl implements IWebsocketService {

    private static final long CACHE_DURATION = 5 * 60 * 1000;

    private ConcurrentHashMap<String, CacheEntry> cache = new ConcurrentHashMap<>();

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

        String key = geolocation.getDriverId() + "-" + geolocation.getCustomerId();
        CacheEntry entry = new CacheEntry(geolocation, System.currentTimeMillis());
        cache.put(key, entry);

        this.geolocationRepository.save(geolocation);
        return geolocation;
    }


    @Scheduled(fixedRate = CACHE_DURATION)
    public void saveToDatabase() {
        System.out.println("======== Time to save cache to db ======== ");
        System.out.println("======== Cache size to save is ======== " + cache.size());
        for (CacheEntry entry : cache.values()) {
            this.geolocationRepository.save(entry.getParameter());
        }
        System.out.println("======== Now clearing cache ======== ");
        cache.clear();
        System.out.println("======== Cache size after clearing is ======== " + cache.size());
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
    public void sendMatchToDriver(String customer) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Customer raw = objectMapper.readValue(customer, Customer.class);
            System.out.println("====== Kafka matched topic listener in websocket service triggered with ===== " + customer);
            // Sending with websocket
            this.simpMessagingTemplate.convertAndSend("/matched", customer);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void setSession(Session session) {

    }


    private static class CacheEntry {
        private  Geolocation parameter;
        private long timestamp;

        public CacheEntry( Geolocation parameter, long timestamp) {
            this.parameter = parameter;
            this.timestamp = timestamp;
        }

        public  Geolocation getParameter() {
            return parameter;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }


}
