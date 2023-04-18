package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;

import javax.websocket.Session;

public interface IWebsocketService {
    Geolocation forwardLocationToKafka(MessageDTO theMessage);
    void sendAcceptanceToCustomer(Ride ride);

    void sendMatchToDriver(Customer customer);

    void setSession(Session session);
}
