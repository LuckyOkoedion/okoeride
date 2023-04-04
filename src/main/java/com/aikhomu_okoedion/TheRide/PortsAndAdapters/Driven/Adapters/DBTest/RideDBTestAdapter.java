package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RideDBTestAdapter implements RideRepository {

    @Override
    public Ride save(Ride entity) {
        return entity;
    }

    @Override
    public <S extends Ride> List<S> saveAll(Iterable<S> entites) {
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
    public List<Ride> findAll() {
        return null;
    }

    @Override
    public List<Ride> findAllById(Iterable<Integer> integers) {
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

    @Override
    public Slice<Ride> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ride> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Ride> List<S> insert(Iterable<S> entities) {
        return null;
    }
}
