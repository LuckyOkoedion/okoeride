package com.aikhomu_okoedion.TheRide.Core.Service.Interfaces;

import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;

public interface IWebsocketService {
    void publish(MessageDTO theMessage);
    void subscribe();
}
