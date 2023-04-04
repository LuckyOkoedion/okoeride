package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements IDriverService {

    @Autowired
    ISystemService systemService;


    DriverRepository driverRepository;

    @Autowired
    IWebsocketService websocketService;

    @Autowired
    @Qualifier("kafkaMessageAdapter")
    IMessagePort message;


    public DriverServiceImpl(DriverDBAdapter driverDBAdapter) {
        this.driverRepository = driverDBAdapter;
    }



    @Override
    public void acceptRequest(RideDTO rideDetails) {
        // Todo - Add to ride db
    }

    @Override
    public void broadcastLocation(int driverId, GeolocationDTO location) {
        // Todo - Push location to kafka
    }

    @Override
    public MessageDTO getMatchedRide(int driverId) {
        // Todo - Get matched Ride from Kafka for driver
        return null;
    }
}
