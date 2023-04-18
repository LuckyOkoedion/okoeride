package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RideDBTestAdapter implements RideRepository {

   // private static List<Ride> mockDB = new ArrayList<>();

    @Override
    public Ride save(Ride entity) {
        // mockDB.add(entity);
        return entity;
    }

    @Override
    public <S extends Ride> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Ride> findById(Integer integer) {
        List<Ride> mockDB = new ArrayList<>();

        Ride ride = new Ride();
        ride.setId(23456097);
        mockDB.add(ride);

        List<Ride> filtered = mockDB.stream().filter(val -> val.getId().equals(integer)).collect(Collectors.toList());
        return Optional.ofNullable(filtered.get(0));
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Ride> findAll() {
        List<Ride> mockDB = new ArrayList<>();
        return mockDB;
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
