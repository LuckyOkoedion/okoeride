package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.CustomerDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ISystemService systemService;

    CustomerRepository customerRepository;

    @Autowired
    IWebsocketService websocketService;


    public CustomerServiceImpl(CustomerDBAdapter customerDBAdapter) {
        this.customerRepository = customerDBAdapter;
    }


    @Override
    public MessageDTO requestRide(int customerId, GeolocationDTO location) {
        // Todo - Add to 'pending' kafka
     return this.getMatchedRide(customerId);


    }

    @Override
    public Customer createCustomer(CustomerDTO customer) {

        // Todo - Save to customer db
        return null;
    }

    @Override
    public void broadcastLocation(int customerId, GeolocationDTO location) {
        // Todo - Add to 'pending' kafka
    }

    @Override
    public MessageDTO getMatchedRide(int customerId) {
        // Todo - Call system matcher
        return null;
    }
}
