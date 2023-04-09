package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;

import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.DriverTestAdapter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class DriverUseCaseTests {


    @Test
    void driverCanGetPendingRequest() {

        DriverTestAdapter entryPoint = new DriverTestAdapter();

      assertThatCode(() -> entryPoint.getMatchedRide(3000)).doesNotThrowAnyException();



    }


    @Test
    void driverCanAcceptCustomerRequest() {

        DriverTestAdapter entryPoint = new DriverTestAdapter();

        Ride ride = new Ride();

        assertThatCode(() -> entryPoint.acceptRequest(ride)).doesNotThrowAnyException();


    }



}
