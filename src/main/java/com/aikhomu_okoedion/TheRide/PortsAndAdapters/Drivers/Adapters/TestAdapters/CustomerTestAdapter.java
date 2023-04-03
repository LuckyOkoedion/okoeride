package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.ICustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerTestAdapter implements ICustomerPort {

    @Autowired
    ICustomerService customerService;


    @Override
    public MessageDTO requestRide(int customerId, GeolocationDTO location) {
        return null;
    }

    @Override
    public void broadcastLocation(int customerId, GeolocationDTO location) {

    }

    @Override
    public MessageDTO getMatchedRide(int customerId) {
        return null;
    }

    @Override
    public Customer createCustomer(CustomerDTO customer) {
        return null;
    }
}
