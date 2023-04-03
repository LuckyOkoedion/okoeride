package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;


import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;

public interface ICustomerService {
    MessageDTO requestRide(int customerId, GeolocationDTO location);

    Customer createCustomer(CustomerDTO customer);
    void broadcastLocation(int customerId, GeolocationDTO location);

    MessageDTO getMatchedRide(int customerId);
}
