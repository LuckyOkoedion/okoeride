package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;

import java.util.Optional;

public class GeolocationDBTestAdapter implements GeolocationRepository {
    @Override
    public Geolocation save(Geolocation entity) {
        return null;
    }

    @Override
    public <S extends Geolocation> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Geolocation> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Geolocation> findAll() {
        return null;
    }

    @Override
    public Iterable<Geolocation> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Geolocation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Geolocation> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
