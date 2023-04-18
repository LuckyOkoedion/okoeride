package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;

import com.aikhomu_okoedion.TheRide.Core.Service.Impl.DriverServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.CustomerDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.RideDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DriverTestAdapter implements IDriverPort {


    IDriverService driverService;

    public DriverTestAdapter() {
        KafkaTestAdapter kafkaTestAdapter = new KafkaTestAdapter();
        RideDBTestAdapter rideDBTestAdapter = new RideDBTestAdapter();
        DriverDBTestAdapter driverDBTestAdapter = new DriverDBTestAdapter();
        CustomerDBTestAdapter customerDBTestAdapter = new CustomerDBTestAdapter();
        SystemServiceImpl systemService = new SystemServiceImpl(kafkaTestAdapter, rideDBTestAdapter, driverDBTestAdapter, customerDBTestAdapter);

        GeolocationDBTestAdapter geolocationDBTestAdapter = new GeolocationDBTestAdapter();
        WebsocketServiceImpl websocketService = new WebsocketServiceImpl(geolocationDBTestAdapter, kafkaTestAdapter);

        this.driverService = new DriverServiceImpl(systemService, driverDBTestAdapter, websocketService, kafkaTestAdapter, rideDBTestAdapter);
    }

    @Override
    public void acceptRequest(Customer customerDetails) {
        this.driverService.acceptRequest(customerDetails);
    }

    @Override
    public Driver getDriverById(Integer driverId) {
        return this.driverService.getById(driverId);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return this.driverService.getAll();
    }


}
