package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IAdminService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IAdminPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminWebAdapter implements IAdminPort {

    @Autowired
    IAdminService adminService;

    @Operation(summary = "Onboard driver")
    @PostMapping("/onboard-driver")
    @Override
    public Driver onboardDriver( @RequestBody DriverDTO theDriver) {
        return ResponseEntity.ok(this.adminService.onboardDriver(theDriver)).getBody();
    }
}
