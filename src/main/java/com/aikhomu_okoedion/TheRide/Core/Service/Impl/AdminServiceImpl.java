package com.aikhomu_okoedion.TheRide.Core.Service.Impl;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.IAdminService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {


    DriverRepository driverRepository;


    @Autowired
    public AdminServiceImpl(DriverDBAdapter driverDBAdapter) {
        this.driverRepository = driverDBAdapter;
    }

    public AdminServiceImpl(DriverDBTestAdapter driverDBTestAdapter) {

        this.driverRepository = driverDBTestAdapter;

    }



    @Override
    public Driver onboardDriver(DriverDTO theDriver) {
        Driver theD = new Driver();
        theD.setName(theDriver.getName());

        return this.driverRepository.save(theD);
    }
}
