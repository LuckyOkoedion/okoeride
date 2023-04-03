package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.DriverTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.IDriverPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DriverUseCaseTests {

    IDriverPort driverEntryPoint;

    public DriverUseCaseTests(DriverTestAdapter driverTestAdapter) {
        this.driverEntryPoint = driverTestAdapter;
    }

    @Test
    void driverCanAcceptCustomerRequest() {

    }



}
