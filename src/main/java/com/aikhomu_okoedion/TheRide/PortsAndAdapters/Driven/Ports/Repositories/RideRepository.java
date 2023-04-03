package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RideRepository extends CrudRepository<Ride, Integer> {
}
