package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;

import java.util.List;

public interface IMessagePort {
   void sendLocationToPending(Geolocation location);
   void sendRideToAccepted(Ride ride);

   void sendCustomerToMatched(Customer driver);

   List<GeolocationDTO> getLocationDataPendingMatch();
}
