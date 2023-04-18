package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.RideDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.RideDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaMessageAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements IDriverService {


    ISystemService systemService;


    DriverRepository driverRepository;

    RideRepository rideRepository;

    IWebsocketService websocketService;

    IMessagePort messenger;


    @Autowired
    public DriverServiceImpl(DriverDBAdapter driverDBAdapter, SystemServiceImpl systemServiceImpl,
                             WebsocketServiceImpl websocketServiceImpl, KafkaMessageAdapter kafkaMessageAdapter,
                             RideDBAdapter rideDBAdapter) {
        this.driverRepository = driverDBAdapter;
        this.systemService = systemServiceImpl;
        this.websocketService = websocketServiceImpl;
        this.messenger = kafkaMessageAdapter;
        this.rideRepository = rideDBAdapter;
    }

    public DriverServiceImpl(SystemServiceImpl systemService, DriverDBTestAdapter dbTestAdapter,
                             WebsocketServiceImpl websocketServiceImpl, KafkaTestAdapter kafkaTestAdapter,
                             RideDBTestAdapter rideDBTestAdapter) {
        this.systemService = systemService;
        this.driverRepository = dbTestAdapter;
        this.websocketService = websocketServiceImpl;
        this.rideRepository = rideDBTestAdapter;
        this.messenger = kafkaTestAdapter;

    }



    @Override
    public void acceptRequest(Customer customerDetails) {
        Ride theRide = this.rideRepository.findById(customerDetails.getRideId()).get();
        this.messenger.sendRideToAccepted(theRide);
    }

    @Override
    public List<Ride> getMatchedRide(int driverId) {
        List<Ride> rides = this.rideRepository.findAll();
       List<Ride> toAccept = rides.stream().filter(val -> val.isDriverAccepted() == false && val.getDriverId().equals(driverId)).collect(Collectors.toList());
        return toAccept;
    }

    @Override
    public Driver getById(Integer driverId) {
        return this.driverRepository.findById(driverId).get();
    }

    @Override
    public List<Driver> getAll() {
        return this.driverRepository.findAll();
    }
}
