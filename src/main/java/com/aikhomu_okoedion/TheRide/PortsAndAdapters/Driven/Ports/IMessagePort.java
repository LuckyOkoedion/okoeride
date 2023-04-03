package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;

public interface IMessagePort {
   void send(Geolocation location);
   void listen();
}
