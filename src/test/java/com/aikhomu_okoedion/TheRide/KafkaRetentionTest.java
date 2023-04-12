//package com.aikhomu_okoedion.TheRide;
//
//import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import static org.assertj.core.api.Assertions.*;
//
//import java.time.Duration;
//import java.time.Instant;
//import java.util.Collections;
//
//@SpringBootTest
//public class KafkaRetentionTest {
//
//    @Autowired
//    @Qualifier("geolocationKafkaTemplate")
//    KafkaTemplate<String, GeolocationDTO> geolocationKafkaTemplate;
//
//    @Autowired
//    @Qualifier("geolocationConsumerFactory")
//    DefaultKafkaConsumerFactory geolocationConsumerFactory;
//
//    @Test
//    public void testRetention() throws InterruptedException {
//        // Configure Kafka producer
//        GeolocationDTO testMessage = new GeolocationDTO();
//        testMessage.setX(50);
//        testMessage.setY(80);
//
//        geolocationKafkaTemplate.send("pending", String.valueOf(Instant.now()), testMessage);
//
//        // Sleep for retention.ms + some buffer time to allow for retention to take effect
//        Thread.sleep(80000);
//
//        Consumer<String, GeolocationDTO> consumer = geolocationConsumerFactory.createConsumer();
//        consumer.subscribe(Collections.singletonList("pending"));
//        ConsumerRecords<String, GeolocationDTO> consumerRecords = consumer.poll(Duration.ofSeconds(5));
//        consumer.commitSync();
//
//        assertThat(consumerRecords).isEmpty();
//
//        consumer.close();
//
//    }
//
//}
