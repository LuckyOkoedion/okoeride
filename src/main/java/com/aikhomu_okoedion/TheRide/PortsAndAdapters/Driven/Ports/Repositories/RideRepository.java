package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import org.springframework.data.cassandra.repository.CassandraRepository;



public interface RideRepository extends CassandraRepository<Ride, Integer> {
}
