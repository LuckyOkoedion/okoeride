package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;

import java.util.List;

public interface IDriverPort {
    void acceptRequest(Ride rideDetails);

    List<Ride> getMatchedRide(int driverId);
}
