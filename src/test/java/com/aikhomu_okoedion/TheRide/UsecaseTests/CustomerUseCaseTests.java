package com.aikhomu_okoedion.TheRide.UsecaseTests;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters.TestAdapters.CustomerTestAdapter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerUseCaseTests {


    @Test
    void customerCanRequestRide() {

        CustomerTestAdapter entryPoint = new CustomerTestAdapter();
        GeolocationDTO geolocationDTO = new GeolocationDTO();
        geolocationDTO.setY(18);
        geolocationDTO.setX(29);
        geolocationDTO.setCustomerId(1000);

        Driver driver = entryPoint.requestRide(1000, geolocationDTO, "7_8");

        assertThat(driver.getId()).isEqualTo(3000);

    }


    @Test
    void customerGetsMatchedToNearestDriver() {

        CustomerTestAdapter entryPoint = new CustomerTestAdapter();
        GeolocationDTO geolocationDTO = new GeolocationDTO();
        geolocationDTO.setY(16);
        geolocationDTO.setX(26);
        geolocationDTO.setCustomerId(2000);

        Driver driver = entryPoint.requestRide(2000, geolocationDTO, "7_8");

        assertThat(driver.getLocationX()).isEqualTo(27);
        assertThat(driver.getLocationY()).isEqualTo(17);

        CustomerTestAdapter entryPoint2 = new CustomerTestAdapter();
        GeolocationDTO geolocationDTO2 = new GeolocationDTO();
        geolocationDTO2.setY(18);
        geolocationDTO2.setX(29);
        geolocationDTO2.setCustomerId(1000);

        Driver driver2 = entryPoint2.requestRide(1000, geolocationDTO2, "5_3");

        assertThat(driver2.getLocationX()).isEqualTo(30);
        assertThat(driver2.getLocationY()).isEqualTo(19);

    }

    @Test
    void customerCanRegister() {

        CustomerDTO customer = new CustomerDTO();
        customer.setName("Test Customer1");

        CustomerTestAdapter entryPoint = new CustomerTestAdapter();

        Customer theCust = entryPoint.createCustomer(customer);

        assertThat(theCust.getName()).isEqualTo(customer.getName());


    }


}
