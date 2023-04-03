package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IWebsocketPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Component
public class WebsocketTestAdapter implements IWebsocketPort {

    @Autowired
    IWebsocketService websocketService;

    @Override
    public void onOpen(Session session) {

    }

    @Override
    public void onMessage(MessageDTO message, Session session) {

    }

    @Override
    public void onClose(Session session) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
