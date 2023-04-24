package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class KafkaMessageAdapter implements IMessagePort {

    private static final long CACHE_DURATION = 2 * 60 * 1000;

    private ConcurrentHashMap<String, KafkaMessageAdapter.CacheEntry> cache = new ConcurrentHashMap<>();

    private final String PENDING_TOPIC = "pending";
    private final String ACCEPTED = "accepted";
    private final String MATCHED = "matched";

    @Autowired
    @Qualifier("geolocationKafkaTemplate")
    KafkaTemplate<String, GeolocationDTO> geolocationKafkaTemplate;

    @Autowired
    @Qualifier("stringKafkaTemplate")
    KafkaTemplate<String, String> stringKafkaTemplate;



    @Autowired
    @Qualifier("rideKafkaTemplate")
    KafkaTemplate<String, Ride> rideKafkaTemplate;

    @Autowired
    @Qualifier("geolocationConsumerFactory")
    DefaultKafkaConsumerFactory geolocationConsumerFactory;



    @Autowired
    private KafkaAdmin kafkaAdmin;


    @Override
    public void sendLocationToPending(Geolocation location) {

        try{
            ObjectMapper om = new ObjectMapper();
            GeolocationDTO data = new GeolocationDTO(location);
            String json = om.writeValueAsString(data);
            System.out.println("========== Attempting to send location broadcast to kafka ============= " + json);
            geolocationKafkaTemplate.send(PENDING_TOPIC, Integer.toString(location.getId()), data);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void sendRideToAccepted(Ride ride) {

        try {

            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(ride);

            System.out.println("========== Attempting to send accepted ride to kafka ============= " + json);

            this.rideKafkaTemplate.send(ACCEPTED, Integer.toString(ride.getId()), ride);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void sendCustomerToMatched(Customer customer) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(customer);
            System.out.println("========== Attempting to send matched customer to kafka ============= " + json);
            this.stringKafkaTemplate.send(MATCHED, String.valueOf(customer.getId()), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }



    }

    @Override
    public List<GeolocationDTO> getLocationDataPendingMatch() {

        try {

            System.out.println("========== System service attempting to get locations pending match from kafka ============= ");

            ArrayList<GeolocationDTO> messages = new ArrayList<>();
            for (CacheEntry entry : cache.values()) {
                messages.add(entry.parameter);
            }

            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(messages);

            System.out.println("======== Result form system call to kafka is =========" + json);

            return messages;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    @KafkaListener(topics = "pending", groupId = "group1")
    public void cachePendingTopicData(String raw) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            GeolocationDTO data = objectMapper.readValue(raw, GeolocationDTO.class);

            System.out.println("====== Kafka pending topic listener  with ===== " + raw);

            String key = data.getDriverId() + "-" + data.getCustomerId();
            KafkaMessageAdapter.CacheEntry entry = new KafkaMessageAdapter.CacheEntry(data, System.currentTimeMillis());
            cache.put(key, entry);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }


    @Scheduled(fixedRate = CACHE_DURATION)
    public void refreshPendingCache() {
        System.out.println("======== Time to refresh pending cache ======== ");
        System.out.println("======== Cache size before refresh is ======== " + cache.size());
        System.out.println("======== Now refreshing cache ======== ");
        cache.clear();
        System.out.println("======== Cache size after refreshing is ======== " + cache.size());
    }


    private static class CacheEntry {
        private  GeolocationDTO parameter;
        private long timestamp;

        public CacheEntry( GeolocationDTO parameter, long timestamp) {
            this.parameter = parameter;
            this.timestamp = timestamp;
        }

        public  GeolocationDTO getParameter() {
            return parameter;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }



}
