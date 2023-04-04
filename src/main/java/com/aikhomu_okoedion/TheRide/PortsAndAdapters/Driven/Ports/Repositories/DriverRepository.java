package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import org.springframework.data.cassandra.repository.CassandraRepository;



public interface DriverRepository extends CassandraRepository<Driver, Integer> {
}
