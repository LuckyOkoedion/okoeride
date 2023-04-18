package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KafkaTestAdapter implements IMessagePort {

   // private static List<Geolocation> mockKafka = new ArrayList<>();

    @Override
    public void sendLocationToPending(Geolocation location) {

        List<Geolocation> mockKafka = new ArrayList<>();

        mockKafka.add(location);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(location);
            System.out.println("===== Location published to kafka =====" + json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendRideToAccepted(Ride ride) {
        List<Ride> mockKafka = new ArrayList<>();

        mockKafka.add(ride);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(ride);
            System.out.println("===== accepted ride published to kafka =====" + json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendCustomerToMatched(Customer customer) {

        List<Customer> mockKafka = new ArrayList<>();

        mockKafka.add(customer);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(customer);
            System.out.println("===== matched customer published to kafka =====" + json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<GeolocationDTO> getLocationDataPendingMatch() {
        List<GeolocationDTO> mockKafka = new ArrayList<>();


        GeolocationDTO driver1Location = new GeolocationDTO();
        driver1Location.setDriverId(1000);
        driver1Location.setY(15);
        driver1Location.setX(20);

        GeolocationDTO driver2Location = new GeolocationDTO();

        driver2Location.setDriverId(2000);
        driver2Location.setY(17);
        driver2Location.setX(27);

        GeolocationDTO driver3Location = new GeolocationDTO();

        driver3Location.setDriverId(3000);
        driver3Location.setY(19);
        driver3Location.setX(30);

        GeolocationDTO customer1Location = new GeolocationDTO();

        customer1Location.setCustomerId(1000);
        customer1Location.setY(18);
        customer1Location.setX(29);

        GeolocationDTO customer2Location = new GeolocationDTO();

        customer2Location.setCustomerId(2000);
        customer2Location.setY(16);
        customer2Location.setX(26);

        GeolocationDTO customer3Location = new GeolocationDTO();

        customer3Location.setCustomerId(3000);
        customer3Location.setY(23);
        customer3Location.setX(25);

        mockKafka.add(driver1Location);
        mockKafka.add(driver2Location);
        mockKafka.add(driver3Location);
        mockKafka.add(customer1Location);
        mockKafka.add(customer2Location);
        mockKafka.add(customer3Location);

        return mockKafka;
    }
}
