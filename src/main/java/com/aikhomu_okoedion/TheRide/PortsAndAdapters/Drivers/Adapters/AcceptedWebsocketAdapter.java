package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IWebsocketPort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/accepted")
public class AcceptedWebsocketAdapter implements IWebsocketPort  {

    @Autowired
    IWebsocketService websocketService;


    @Override
    public void onOpen(Session session) {

        this.websocketService.setSession(session);

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
