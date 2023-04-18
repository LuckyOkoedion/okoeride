package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;

import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.DriverTestAdapter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class DriverUseCaseTests {



    @Test
    void driverCanAcceptCustomerRequest() {

        DriverTestAdapter entryPoint = new DriverTestAdapter();

        Customer customer = new Customer();
        customer.setRideId(23456097);

        assertThatCode(() -> entryPoint.acceptRequest(customer)).doesNotThrowAnyException();


    }



}
