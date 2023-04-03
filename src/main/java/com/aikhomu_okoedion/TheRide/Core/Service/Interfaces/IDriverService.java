package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;

public interface IDriverService {
    void acceptRequest(RideDTO rideDetails);
    void broadcastLocation(int driverId, GeolocationDTO location);

    MessageDTO getMatchedRide(int driverId);
}
