package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;

import java.util.List;

public interface IDriverService {
    void acceptRequest(Ride rideDetails);

    List<Ride> getMatchedRide(int driverId);
}
