package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Impl.AdminServiceImpl;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IAdminService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IAdminPort;
import org.springframework.stereotype.Component;

@Component
public class AdminTestAdapter implements IAdminPort {


    IAdminService adminService;


    public AdminTestAdapter() {

        DriverDBTestAdapter driverDBTestAdapter = new DriverDBTestAdapter();
        this.adminService = new AdminServiceImpl(driverDBTestAdapter);

    }

    @Override
    public Driver onboardDriver(DriverDTO theDriver) {

        return this.adminService.onboardDriver(theDriver);
    }


}
