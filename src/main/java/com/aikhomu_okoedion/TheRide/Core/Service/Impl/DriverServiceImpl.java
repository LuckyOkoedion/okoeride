package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaMessageAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements IDriverService {


    ISystemService systemService;


    DriverRepository driverRepository;

    IWebsocketService websocketService;

    IMessagePort messenger;


    @Autowired
    public DriverServiceImpl(DriverDBAdapter driverDBAdapter, SystemServiceImpl systemServiceImpl,
                             WebsocketServiceImpl websocketServiceImpl, KafkaMessageAdapter kafkaMessageAdapter) {
        this.driverRepository = driverDBAdapter;
        this.systemService = systemServiceImpl;
        this.websocketService = websocketServiceImpl;
        this.messenger = kafkaMessageAdapter;
    }

    public DriverServiceImpl(SystemServiceImpl systemService, DriverDBTestAdapter dbTestAdapter,
                             WebsocketServiceImpl websocketServiceImpl, KafkaTestAdapter kafkaTestAdapter) {
        this.systemService = systemService;
        this.driverRepository = dbTestAdapter;
        this.websocketService = websocketServiceImpl;
        this.messenger = kafkaTestAdapter;

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
