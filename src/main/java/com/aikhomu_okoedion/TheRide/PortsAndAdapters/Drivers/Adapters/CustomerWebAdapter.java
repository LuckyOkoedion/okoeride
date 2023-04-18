package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Adapters;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Dtos.CustomerDTO;
import com.aikhomu_okoedion.TheRide.Core.Dtos.GeolocationDTO;
import com.aikhomu_okoedion.TheRide.Core.Service.Interfaces.ICustomerService;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Drivers.Ports.ICustomerPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerWebAdapter implements ICustomerPort {

    @Autowired
    ICustomerService customerService;


    @Operation(summary = "Customer requests ride", description = "Request made here but response from websocket at 'ws://localhost:8080/accepted' is used by clients, not response from here")
    @PostMapping("/request/{customerId}/{destination}")
    @Override
    public Driver requestRide(@PathVariable Integer customerId, @RequestBody GeolocationDTO location, @PathVariable String destination) {

       return ResponseEntity.ok(this.customerService.requestRide(customerId, location, destination)).getBody();

    }


    @Operation(summary = "Customer registers")
    @PostMapping
    @Override
    public Customer createCustomer(@RequestBody CustomerDTO customer) {
        return ResponseEntity.ok(this.customerService.createCustomer(customer)).getBody();
    }

    @Operation(summary = "Get customer by Id")
    @GetMapping("/{id}")
    @Override
    public Customer getCustomerById(@PathVariable Integer customerId) {
        return ResponseEntity.ok(this.customerService.getById(customerId)).getBody();
    }

    @Operation(summary = "Get all customers")
    @GetMapping
    @Override
    public List<Customer> getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getAll()).getBody();
    }


}
