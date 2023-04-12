package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;

public interface ICustomerPort {
    Driver requestRide(int customerId, GeolocationDTO location, String destination);
    void broadcastLocation(int customerId, GeolocationDTO location);

    Ride getMatchedRide(int customerId, String destination);

    Customer createCustomer(CustomerDTO customer);
}
