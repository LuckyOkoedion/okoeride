package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;

import java.util.Optional;

public class RideDBTestAdapter implements RideRepository {
    @Override
    public Ride save(Ride entity) {
        return null;
    }

    @Override
    public <S extends Ride> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Ride> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Ride> findAll() {
        return null;
    }

    @Override
    public Iterable<Ride> findAllById(Iterable<Integer> integers) {
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
    public void delete(Ride entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ride> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
