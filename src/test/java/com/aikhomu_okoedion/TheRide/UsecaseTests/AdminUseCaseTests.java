package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB.DriverDBAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest.DriverDBTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.AdminTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IAdminPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class AdminUseCaseTests {

   /// @Autowired
    DriverDBTestAdapter driverTestRepository;

  //  @Autowired
    AdminTestAdapter adminEntryPoint;

    @Mock
    DriverDBAdapter driverDBAdapter;


//    public AdminUseCaseTests(AdminTestAdapter adminTestAdapter, DriverDBTestAdapter dbTestAdapter) {
//        this.adminEntryPoint = adminTestAdapter;
//        this.driverTestRepository = dbTestAdapter;
//
//    }

    @BeforeEach
    public void setup() {
        this.driverTestRepository = new DriverDBTestAdapter();
        this.adminEntryPoint = new AdminTestAdapter();
        this.driverDBAdapter = new DriverDBAdapter();
    }

    @Test
    void companyCanOnboardDriver() {

        DriverDTO inputDto = new DriverDTO();
        inputDto.setName("Test Driver 1");

        Driver inputedDriver = new Driver();
        inputedDriver.setName("Test Driver 1");

        Driver expectedDr = this.driverTestRepository.save(inputedDriver);

        when(this.driverDBAdapter.save(inputedDriver)).thenReturn(expectedDr);


        Driver actualDriver = this.adminEntryPoint.onboardDriver(inputDto);

        assertEquals(expectedDr, actualDriver);









    }


}
