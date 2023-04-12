package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.DriverDTO;

import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.AdminTestAdapter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;




public class AdminUseCaseTests {


    @Test
    void companyCanOnboardDriver() {

        AdminTestAdapter adminEntryPoint = new AdminTestAdapter();

        DriverDTO inputDto = new DriverDTO();
        inputDto.setName("Test Driver1");

        Driver res = adminEntryPoint.onboardDriver(inputDto);

        assertThat(res.getName()).isEqualTo(inputDto.getName());



    }


}
