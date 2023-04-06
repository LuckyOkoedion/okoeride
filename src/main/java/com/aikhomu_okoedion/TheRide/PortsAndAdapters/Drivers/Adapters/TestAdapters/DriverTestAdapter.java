package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.DriverServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.Core.System.Impl.SystemServiceImpl;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.RideDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverTestAdapter implements IDriverPort {


    IDriverService driverService;

    public DriverTestAdapter() {
        KafkaTestAdapter kafkaTestAdapter = new KafkaTestAdapter();
        RideDBTestAdapter rideDBTestAdapter = new RideDBTestAdapter();
        DriverDBTestAdapter driverDBTestAdapter = new DriverDBTestAdapter();
        SystemServiceImpl systemService = new SystemServiceImpl(kafkaTestAdapter, rideDBTestAdapter, driverDBTestAdapter);

        GeolocationDBTestAdapter geolocationDBTestAdapter = new GeolocationDBTestAdapter();
        WebsocketServiceImpl websocketService = new WebsocketServiceImpl(geolocationDBTestAdapter, kafkaTestAdapter);

        this.driverService = new DriverServiceImpl(systemService, driverDBTestAdapter, websocketService, kafkaTestAdapter);
    }

    @Override
    public void acceptRequest(RideDTO rideDetails) {
        this.driverService.acceptRequest(rideDetails);
    }

    @Override
    public void broadcastLocation(int driverId, GeolocationDTO location) {
        this.driverService.broadcastLocation(driverId, location);

    }

    @Override
    public MessageDTO getMatchedRide(int driverId) {
        return this.driverService.getMatchedRide(driverId);
    }
}
