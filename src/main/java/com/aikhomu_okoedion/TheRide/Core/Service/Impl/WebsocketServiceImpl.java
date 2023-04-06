package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.GeolocationDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaMessageAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.IMessagePort;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsocketServiceImpl implements IWebsocketService {

    IMessagePort messenger;

    GeolocationRepository geolocationRepository;


    @Autowired
    public WebsocketServiceImpl(GeolocationDBAdapter geolocationDBAdapter, KafkaMessageAdapter kafkaMessageAdapter) {

        this.geolocationRepository = geolocationDBAdapter;
        this.messenger = kafkaMessageAdapter;

    }


    public WebsocketServiceImpl(GeolocationDBTestAdapter geolocationTestDBAdapter, KafkaTestAdapter kafkaTestAdapter) {

        this.geolocationRepository = geolocationTestDBAdapter;
        this.messenger = kafkaTestAdapter;

    }

    @Override
    public Geolocation publish(MessageDTO theMessage) {
        Geolocation geolocation = new Geolocation(theMessage);
       this.messenger.send(geolocation);
        this.geolocationRepository.save(geolocation);
        return geolocation;
    }

    @Override
    public void subscribe() {

    }
}
