package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;


import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;

public interface ICustomerService {
    Driver requestRide(int customerId, GeolocationDTO location, String destination);

    Customer createCustomer(CustomerDTO customer);
    void broadcastLocation(int customerId, GeolocationDTO location);

    Ride getMatchedRide(int customerId, String destination);
}
