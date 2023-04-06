package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
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
    private final String PENDING_CONTROL = "pending-control";
    private final String MATCHED = "matched";
    private final String MATCHED_CONTROL = "matched-control";

    @Autowired
    @Qualifier("geolocationKafkaTemplate")
    KafkaTemplate<String, GeolocationDTO> geolocationKafkaTemplate;

    @Autowired
    @Qualifier("stringKafkaTemplate")
    KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    @Qualifier("geolocationConsumerFactory")
    DefaultKafkaConsumerFactory geolocationConsumerFactory;



    @Autowired
    private KafkaAdmin kafkaAdmin;


    @Override
    public void send(Geolocation location) {
        GeolocationDTO data = new GeolocationDTO(location);
        geolocationKafkaTemplate.send(PENDING_TOPIC, Integer.toString(location.getId()), data);
    }

    @Override
    public List<GeolocationDTO> getLocationDataPendingMatch() {
        Consumer<String, GeolocationDTO> consumer = geolocationConsumerFactory.createConsumer();
        consumer.subscribe(Collections.singletonList(this.PENDING_TOPIC));
        List<GeolocationDTO> messages = new ArrayList<>();
        ConsumerRecords<String, GeolocationDTO> consumerRecords = consumer.poll(Duration.ofSeconds(1));
        for (ConsumerRecord<String, GeolocationDTO> record : consumerRecords) {
            messages.add(record.value());
        }

        consumer.commitSync();
        consumer.close();

        return messages;
    }



}
