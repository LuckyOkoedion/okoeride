package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;



public interface CustomerRepository extends CassandraRepository<Customer, Integer> {
}
