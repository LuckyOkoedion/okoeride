package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IAdminService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {

    DriverRepository driverRepository;


    public AdminServiceImpl (DriverDBAdapter driverDBAdapter) {
        driverRepository = driverDBAdapter;
    }


    @Override
    public Driver onboardDriver(DriverDTO theDriver) {
        Driver theD = new Driver();
        theD.setName(theDriver.getName());

        return this.driverRepository.save(theD);
    }
}
