package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DriverRepository extends CrudRepository<Driver, Integer> {
}
