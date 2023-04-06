package com.aikhomu_okoedion.TheRide.Core.System.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;


public interface ISystemService {
    Geolocation trackDriverLocation(int driverId);
    Driver matchCustToDriver(int customerId, GeolocationDTO customerLocation, String destination);

    void notifyDriverOfCust(int driverId);
}
