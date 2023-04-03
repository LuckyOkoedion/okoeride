package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.RideDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("driver")
public class DriverWebAdapter implements IDriverPort {

    @Autowired
    IDriverService driverService;

    @PostMapping("/accept-ride")
    @Override
    public void acceptRequest( @RequestBody RideDTO rideDetails) {
        this.driverService.acceptRequest(rideDetails);
    }

    @PostMapping("/broadcast-location/{driverId}")
    @Override
    public void broadcastLocation(@PathVariable int driverId, @RequestBody GeolocationDTO location) {
        this.driverService.broadcastLocation(driverId, location);
    }

    @GetMapping("/{driverId}")
    @Override
    public MessageDTO getMatchedRide(@PathVariable int driverId) {
       return ResponseEntity.ok(this.driverService.getMatchedRide(driverId)).getBody();
    }
}
