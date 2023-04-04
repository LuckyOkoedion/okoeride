package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import org.springframework.data.cassandra.repository.CassandraRepository;



public interface GeolocationRepository extends CassandraRepository<Geolocation, Integer> {
}
