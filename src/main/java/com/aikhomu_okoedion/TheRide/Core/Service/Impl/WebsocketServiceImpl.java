package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.GeolocationDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebsocketServiceImpl implements IWebsocketService {

    @Autowired
    @Qualifier("kafkaMessageAdapter")
    IMessagePort messenger;

    GeolocationRepository geolocationRepository;

    public WebsocketServiceImpl(GeolocationDBAdapter geolocationDBAdapter) {

        this.geolocationRepository = geolocationDBAdapter;

    }

    @Override
    public void publish(MessageDTO theMessage) {
//        TODO - Public to kafka
//        TODO - Save to Cassandra DB

    }

    @Override
    public void subscribe() {

    }
}
