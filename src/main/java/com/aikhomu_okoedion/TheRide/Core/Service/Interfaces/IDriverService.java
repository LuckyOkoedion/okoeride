package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;

import java.util.List;

public interface IDriverService {
    void acceptRequest(Customer customerDetails);

    List<Ride> getMatchedRide(int driverId);

    Driver getById(Integer driverId);

    List<Driver> getAll();
}
