package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverWebAdapter implements IDriverPort {

    @Autowired
    IDriverService driverService;

    @PostMapping("/accept-ride")
    @Override
    public void acceptRequest( @RequestBody Ride rideDetails) {
        this.driverService.acceptRequest(rideDetails);
    }


    @GetMapping("/{driverId}")
    @Override
    public List<Ride> getMatchedRide(@PathVariable int driverId) {
       return ResponseEntity.ok(this.driverService.getMatchedRide(driverId)).getBody();
    }
}
