package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface GeolocationRepository extends CrudRepository<Geolocation, Integer> {
}
