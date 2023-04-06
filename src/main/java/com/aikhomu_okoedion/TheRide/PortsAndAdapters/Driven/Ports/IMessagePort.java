package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;

import java.util.List;

public interface IMessagePort {
   void send(Geolocation location);
   List<GeolocationDTO> getLocationDataPendingMatch();
}
