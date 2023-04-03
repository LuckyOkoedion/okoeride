package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.CustomerTestAdapter;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.ICustomerPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerUseCaseTests {

    ICustomerPort customerEntryPoint;

    public CustomerUseCaseTests(CustomerTestAdapter customerTestAdapter) {
        this.customerEntryPoint = customerTestAdapter;
    }

    @Test
    void customerCanRequestRideAndBeMatched() {

    }


}
