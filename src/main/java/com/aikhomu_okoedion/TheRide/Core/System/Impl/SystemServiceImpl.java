package com.aikhomu_okoedion.TheRide.Core.System.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.System.Interfaces.ISystemService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements ISystemService {

    @Autowired
    IMessagePort messenger;


    @Override
    public Geolocation trackDriverLocation(int driverId) {

        // Todo - get latest driver location from kafka 'pending'

        return null;
    }

    @Override
    public Driver matchCustToDriver(int customerId, GeolocationDTO customerLocation) {
        // Todo - get latest 'pending' location broadcasts from kafka
        // Todo - use algorithm to match
        // Todo - publish matched to kafka "matched"

        return null;
    }

    @Override
    public void notifyDriverOfCust(int driverId) {

    }
}
