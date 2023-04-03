package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;

public interface ICustomerPort {
    MessageDTO requestRide(int customerId, GeolocationDTO location);
    void broadcastLocation(int customerId, GeolocationDTO location);

    MessageDTO getMatchedRide(int customerId);

    Customer createCustomer(CustomerDTO customer);
}
