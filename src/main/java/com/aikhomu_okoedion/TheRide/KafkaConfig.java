package com.aikhomu_okoedion.TheRide;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.topic.retention.check.interval.ms}")
    private String topicRetentionCheckIntervalMs;

    @Value("${spring.kafka.producer.topic.retention.ms}")
    private String topicRetentionMs;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }


    @Bean
    public KafkaAdmin.NewTopics topics() {

        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("pending")
                        .configs(Map.of(
                                "retention.ms", topicRetentionMs
                        ))
                        .build(),
                TopicBuilder.name("matched")
                        .partitions(1)
                        .configs(Map.of(
                                "retention.ms", topicRetentionMs
                        ))
                        .build(),
                TopicBuilder.name("accepted")
                        .partitions(1)
                        .configs(Map.of(
                                "retention.ms", topicRetentionMs
                        ))
                        .build()
        );

    }

    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    @Bean
    public ProducerFactory<String, GeolocationDTO> geolocationProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }


    @Bean
    public ProducerFactory<String, Ride> rideProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }


    @Bean
    public KafkaTemplate<String, GeolocationDTO> geolocationKafkaTemplate() {
        return new KafkaTemplate<>(geolocationProducerFactory());
    }


    @Bean
    public KafkaTemplate<String, Ride> rideKafkaTemplate() {
        return new KafkaTemplate<>(rideProducerFactory());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> stringListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(stringConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, GeolocationDTO> geolocationListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, GeolocationDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(geolocationConsumerFactory());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Ride> rideListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Ride> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(rideConsumerFactory());
        return factory;
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, String> stringConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, GeolocationDTO> geolocationConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(GeolocationDTO.class));
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, Ride> rideConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(Ride.class));
    }

}
