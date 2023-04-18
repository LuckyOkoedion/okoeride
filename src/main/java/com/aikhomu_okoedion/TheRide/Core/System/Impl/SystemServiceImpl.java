package com.aikhomu_okoedion.TheRide.Core.System.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.CustomerDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.RideDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.CustomerDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.RideDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaMessageAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SystemServiceImpl implements ISystemService {


    IMessagePort messenger;

    RideRepository rideRepository;

    DriverRepository driverRepository;

    CustomerRepository customerRepository;


    @Autowired
    public SystemServiceImpl(KafkaMessageAdapter kafkaMessageAdapter, RideDBAdapter rideDBAdapter,
                             DriverDBAdapter driverDBAdapter, CustomerDBAdapter customerDBAdapter) {
        this.messenger = kafkaMessageAdapter;
        this.rideRepository = rideDBAdapter;
        this.driverRepository = driverDBAdapter;
        this.customerRepository = customerDBAdapter;
    }

    public SystemServiceImpl(KafkaTestAdapter kafkaTestAdapter, RideDBTestAdapter rideDBTestAdapter,
                             DriverDBTestAdapter driverDBTestAdapter, CustomerDBTestAdapter customerDBTestAdapter) {
        this.messenger = kafkaTestAdapter;
        this.rideRepository = rideDBTestAdapter;
        this.driverRepository = driverDBTestAdapter;
        this.customerRepository = customerDBTestAdapter;
    }


    @Override
    public Geolocation trackDriverLocation(int driverId) {

        // Todo - get latest driver location from kafka 'pending'

        return null;
    }

    @Override
    public Driver matchCustToDriver(int customerId, GeolocationDTO customerLocation, String destination) {

        List<GeolocationDTO> locations = this.messenger.getLocationDataPendingMatch();
        List<GeolocationDTO> driverLocations = locations.stream().filter(loc -> loc.getDriverId() != null).collect(Collectors.toList());

        Optional<GeolocationDTO> closestLocation = Optional.of(driverLocations.stream()
                .min(Comparator.comparing(val -> Math.sqrt(Math.pow(val.getX() - customerLocation.getX(), 2)
                        + Math.pow(val.getY() - customerLocation.getY(), 2))))
                .get());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonDriver = objectMapper.writeValueAsString(closestLocation.get());
            String jsonCust = objectMapper.writeValueAsString(customerLocation);
            System.out.println("==== customer location is ===== " + jsonCust);
            System.out.println("==== closest driver location is ======== " + jsonDriver );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Integer theVal = closestLocation.get().getDriverId();

        Optional<Driver> theDriver = this.driverRepository.findById(theVal);

        Driver finDriver = theDriver.get();

        finDriver.setLocationX(closestLocation.get().getX());
        finDriver.setLocationY(closestLocation.get().getY());


        if(theDriver.isEmpty()) {
            throw new RuntimeException("Unable to get driver details after matching");
        }

        Ride theRide = new Ride();

        theRide.setId(Instant.now().getNano());
        theRide.setDriverId(theDriver.get().getId());
        theRide.setDestination(destination);
        theRide.setCustomerId(customerId);
        theRide.setDriverName(theDriver.get().getName());

        Ride savedRide =  this.rideRepository.save(theRide);

        Customer theCustomer = this.customerRepository.findById(customerId).get();
        theCustomer.setDriverId(theDriver.get().getId());
        theCustomer.setLocationY(customerLocation.getY());
        theCustomer.setLocationX(customerLocation.getX());

        theCustomer.setRideId(savedRide.getId());

        this.messenger.sendCustomerToMatched(theCustomer);


        return finDriver;
    }

    @Override
    public void notifyDriverOfCust(int driverId) {

    }
}
