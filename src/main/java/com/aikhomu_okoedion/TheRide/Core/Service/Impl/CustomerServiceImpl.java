package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {


    ISystemService systemService;

    CustomerRepository customerRepository;

    RideRepository rideRepository;

    DriverRepository driverRepository;

    IWebsocketService websocketService;

    IMessagePort messenger;


    @Autowired
    public CustomerServiceImpl(CustomerDBAdapter customerDBAdapter, SystemServiceImpl systemServiceImpl,
                               WebsocketServiceImpl websocketServiceImpl, KafkaMessageAdapter kafkaMessageAdapter,
                               RideDBAdapter rideDBAdapter, DriverDBAdapter driverDBAdapter) {

        this.customerRepository = customerDBAdapter;
        this.systemService = systemServiceImpl;
        this.websocketService = websocketServiceImpl;
        this.messenger = kafkaMessageAdapter;
        this.rideRepository = rideDBAdapter;
        this.driverRepository = driverDBAdapter;
    }


    public CustomerServiceImpl(SystemServiceImpl systemServiceImpl, CustomerDBTestAdapter customerDBTestAdapter,
                               WebsocketServiceImpl websocketServiceImpl, KafkaTestAdapter kafkaTestAdapter,
                               RideDBTestAdapter rideDBTestAdapter, DriverDBTestAdapter driverDBTestAdapter) {

        this.systemService = systemServiceImpl;
        this.customerRepository = customerDBTestAdapter;
        this.websocketService = websocketServiceImpl;
        this.messenger = kafkaTestAdapter;
        this.rideRepository = rideDBTestAdapter;
        this.driverRepository = driverDBTestAdapter;

    }

    @Override
    public Driver requestRide(int customerId, GeolocationDTO location, String destination) {
        Geolocation geolocation = new Geolocation(location);
        this.messenger.send(geolocation);
        Ride res = this.getMatchedRide(customerId, destination);

        Optional<Driver> theDriver = this.driverRepository.findById(res.getDriverId());

        if(theDriver.isEmpty()) {
            throw new RuntimeException("Issue getting matched driver's data");
        }

        Driver finDriver = theDriver.get();
        finDriver.setLocationY(res.getDriverYLocation());
        finDriver.setLocationX(res.getDriverXLocation());
        finDriver.setRideId(res.getId());


        return finDriver;


    }

    @Override
    public Customer createCustomer(CustomerDTO customer) {
        Customer theCust = new Customer(customer);
        return this.customerRepository.save(theCust);
    }

    @Override
    public void broadcastLocation(int customerId, GeolocationDTO location) {
        // Todo - Add to 'pending' kafka
    }

    @Override
    public Ride getMatchedRide(int customerId, String destination) {

        List<GeolocationDTO> locations = messenger.getLocationDataPendingMatch();
        List<GeolocationDTO> hasCustomer = locations.stream()
                .filter(val -> Optional.ofNullable(val.getCustomerId())
                        .map(custId -> custId.equals(customerId))
                        .orElse(false))
                .collect(Collectors.toList());

        if(hasCustomer.isEmpty()) {
            throw new RuntimeException("Issue getting customer location data");
        }

        GeolocationDTO theLocation = hasCustomer.get(0);

       Driver driver = this.systemService.matchCustToDriver(customerId, theLocation, destination);

       Ride theRide = new Ride();

       theRide.setCustomerId(customerId);
       theRide.setDestination(destination);
       theRide.setDriverId(driver.getId());
       theRide.setDriverYLocation(driver.getLocationY());
       theRide.setDriverXLocation(driver.getLocationX());

        return this.rideRepository.save(theRide);
    }
}
