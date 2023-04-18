package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.CustomerServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.CustomerDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.RideDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.ICustomerPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTestAdapter implements ICustomerPort {


    ICustomerService customerService;


    public CustomerTestAdapter () {
        GeolocationDBTestAdapter geo = new GeolocationDBTestAdapter();
        CustomerDBTestAdapter repo = new CustomerDBTestAdapter();
        RideDBTestAdapter rideDBTestAdapter = new RideDBTestAdapter();
        KafkaTestAdapter kafkaTest = new KafkaTestAdapter();
        WebsocketServiceImpl websocket = new WebsocketServiceImpl(geo, kafkaTest);
        DriverDBTestAdapter driverDBTestAdapter = new DriverDBTestAdapter();
        SystemServiceImpl systemService = new SystemServiceImpl(kafkaTest, rideDBTestAdapter, driverDBTestAdapter, repo);



        this.customerService = new CustomerServiceImpl(systemService, repo, websocket, kafkaTest, rideDBTestAdapter, driverDBTestAdapter);
    }


    @Override
    public Driver requestRide(Integer customerId, GeolocationDTO location, String destination) {

       return this.customerService.requestRide(customerId, location, destination);
    }


    @Override
    public Customer createCustomer(CustomerDTO customer) {

        return this.customerService.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return this.customerService.getById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerService.getAll();
    }
}
