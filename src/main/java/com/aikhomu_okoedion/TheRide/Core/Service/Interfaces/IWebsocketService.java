package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;

public interface IWebsocketService {
    Geolocation publish(MessageDTO theMessage);
    void subscribe();
}
