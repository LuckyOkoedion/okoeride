package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;

import java.util.List;

public interface ICustomerPort {
    Driver requestRide(Integer customerId, GeolocationDTO location, String destination);

    Customer createCustomer(CustomerDTO customer);

    Customer getCustomerById(Integer customerId);

    List<Customer> getAllCustomers();
}
