package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.MessageDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.ICustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("customer")
public class CustomerWebAdapter implements ICustomerPort {

    @Autowired
    ICustomerService customerService;


    @PostMapping("/request/{customerId}")
    @Override
    public MessageDTO requestRide(@PathVariable int customerId, @RequestBody GeolocationDTO location) {

       return ResponseEntity.ok(this.customerService.requestRide(customerId, location)).getBody();

    }

    @PostMapping("/broadcast/{customerId}")
    @Override
    public void broadcastLocation(@PathVariable int customerId, @RequestBody GeolocationDTO location) {
        this.customerService.broadcastLocation(customerId, location);
    }

    @GetMapping("/{customerId}")
    @Override
    public MessageDTO getMatchedRide( @PathVariable int customerId) {
        return ResponseEntity.ok(this.customerService.getMatchedRide(customerId)).getBody();
    }

    @PostMapping
    @Override
    public Customer createCustomer(@RequestBody CustomerDTO customer) {
        return ResponseEntity.ok(this.customerService.createCustomer(customer)).getBody();
    }
}
