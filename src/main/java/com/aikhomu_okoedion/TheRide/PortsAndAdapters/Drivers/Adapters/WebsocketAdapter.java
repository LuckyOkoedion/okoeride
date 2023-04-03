package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDecoder;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IWebsocketPort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/websocket", decoders = MessageDecoder.class)
public class WebsocketAdapter implements IWebsocketPort {

    @Autowired
    IWebsocketService websocketService;


    @OnOpen
    @Override
    public void onOpen(Session session) {
        System.out.println("======= WebSocket connection opened =======");

    }

    @OnMessage
    @Override
    public void onMessage(MessageDTO message, Session session) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(message);
            System.out.println("===== Received message =====: " + json);
            this.websocketService.publish(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onClose(Session session) {
        System.out.println("====== WebSocket connection closed ======");

    }

    @OnError
    @Override
    public void onError(Throwable throwable) {

        System.out.println("===== WebSocket error =====: " + throwable.getMessage());

    }
}
