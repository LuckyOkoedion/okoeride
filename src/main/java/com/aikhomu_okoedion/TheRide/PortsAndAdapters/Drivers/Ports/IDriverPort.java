package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;

public interface IDriverPort {
    void acceptRequest(RideDTO rideDetails);
    void broadcastLocation(int driverId, GeolocationDTO location);

    MessageDTO getMatchedRide(int driverId);
}
