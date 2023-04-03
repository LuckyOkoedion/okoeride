package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IAdminService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IAdminPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminTestAdapter implements IAdminPort {

    @Autowired
    IAdminService adminService;

    @Override
    public Driver onboardDriver(DriverDTO theDriver) {

        return this.adminService.onboardDriver(theDriver);
    }
}
