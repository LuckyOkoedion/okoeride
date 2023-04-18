package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IDriverService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverWebAdapter implements IDriverPort {

    @Autowired
    IDriverService driverService;

    @Operation(summary = "Driver accepts ride request", description = "Called in response to data from websocket at 'ws://localhost:8080/matched'")
    @PostMapping("/accept-ride")
    @Override
    public void acceptRequest( @RequestBody Customer customerDetails) {
        this.driverService.acceptRequest(customerDetails);
    }

    @Operation(summary = "Get driver by Id")
    @GetMapping("/{id}")
    @Override
    public Driver getDriverById( @PathVariable Integer driverId) {
        return this.driverService.getById(driverId);
    }

    @Operation(summary = "Get all drivers")
    @GetMapping
    @Override
    public List<Driver> getAllDrivers() {
        return this.driverService.getAll();
    }


}
