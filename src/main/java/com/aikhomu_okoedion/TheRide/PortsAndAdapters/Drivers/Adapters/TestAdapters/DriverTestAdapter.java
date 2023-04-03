package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverTestAdapter implements IDriverPort {

    @Autowired
    IDriverService driverService;

    @Override
    public void acceptRequest(RideDTO rideDetails) {

    }

    @Override
    public void broadcastLocation(int driverId, GeolocationDTO location) {

    }

    @Override
    public MessageDTO getMatchedRide(int driverId) {
        return null;
    }
}
