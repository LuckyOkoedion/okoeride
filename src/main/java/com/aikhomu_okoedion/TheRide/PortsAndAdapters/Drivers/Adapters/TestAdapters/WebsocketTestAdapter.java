package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.GeolocationDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.KafkaTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IWebsocketPort;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Component
public class WebsocketTestAdapter implements IWebsocketPort {


    IWebsocketService websocketService;

    public WebsocketTestAdapter() {
        GeolocationDBTestAdapter geolocationDBTestAdapter = new GeolocationDBTestAdapter();
        KafkaTestAdapter kafkaTestAdapter = new KafkaTestAdapter();

        this.websocketService = new WebsocketServiceImpl(geolocationDBTestAdapter, kafkaTestAdapter);
    }

    @Override
    public void onOpen(Session session) {

    }

    @Override
    public void onMessage(String message, Session session) {

    }

    @Override
    public void onClose(Session session) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
