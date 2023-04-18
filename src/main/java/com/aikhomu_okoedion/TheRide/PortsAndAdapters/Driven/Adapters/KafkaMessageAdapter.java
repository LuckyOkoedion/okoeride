package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class KafkaMessageAdapter implements IMessagePort {

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
            System.out.println("========== Attempting to send ride request to kafka ============= " + json);
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

            Consumer<String, GeolocationDTO> consumer = geolocationConsumerFactory.createConsumer();
            consumer.subscribe(Collections.singletonList(this.PENDING_TOPIC));
            List<GeolocationDTO> messages = new ArrayList<>();
            ConsumerRecords<String, GeolocationDTO> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, GeolocationDTO> record : consumerRecords) {
                messages.add(record.value());
            }

            consumer.commitSync();
            consumer.close();

            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(messages);

            System.out.println("======== Result form system call to kafka is =========" + json);

            return messages;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }



}
