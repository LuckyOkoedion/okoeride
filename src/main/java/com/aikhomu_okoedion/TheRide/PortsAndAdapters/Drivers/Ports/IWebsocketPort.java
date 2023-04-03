package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;


import javax.websocket.Session;

public interface IWebsocketPort {
    void onOpen (Session session);
    void onMessage (MessageDTO message, Session session);
    void onClose (Session session);

    void onError (Throwable throwable);
}
