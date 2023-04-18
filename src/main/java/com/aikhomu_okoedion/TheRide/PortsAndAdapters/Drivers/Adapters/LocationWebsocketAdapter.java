package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;


import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.WebsocketServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IWebsocketService;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class LocationWebsocketAdapter  {

    private final IWebsocketService websocketService;

    @Autowired
    public LocationWebsocketAdapter(WebsocketServiceImpl websocketService) {
        this.websocketService = websocketService;
    }


    @MessageMapping("/location")
    public void getLocation(String message) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MessageDTO theMessage = objectMapper.readValue(message, MessageDTO.class);
            System.out.println("===== Location ws Received message =====: " + message);
            this.websocketService.forwardLocationToKafka(theMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
