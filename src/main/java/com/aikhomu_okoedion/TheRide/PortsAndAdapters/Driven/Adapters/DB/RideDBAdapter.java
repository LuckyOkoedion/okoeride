package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RideDBAdapter implements RideRepository {


    @Autowired
    @Qualifier("rideRepository")
    RideRepository rideRepository;


    @Override
    public Ride save(Ride  entity) {
        return rideRepository.save(entity);
    }

    @Override
    public <S extends Ride> List<S> saveAll(Iterable<S> entites) {
        return rideRepository.saveAll(entites);
    }

    @Override
    public Optional<Ride> findById(Integer integer) {
        return rideRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return rideRepository.existsById(integer);
    }

    @Override
    public List<Ride> findAll() {
        return rideRepository.findAll();
    }

    @Override
    public List<Ride> findAllById(Iterable<Integer> integers) {
        return rideRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return rideRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        rideRepository.deleteById(integer);
    }

    @Override
    public void delete(Ride entity) {
        rideRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        rideRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Ride> entities) {
        rideRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        rideRepository.deleteAll();
    }

    @Override
    public Slice<Ride> findAll(Pageable pageable) {
        return rideRepository.findAll(pageable);
    }

    @Override
    public <S extends Ride> S insert(S entity) {
        return rideRepository.insert(entity);
    }

    @Override
    public <S extends Ride> List<S> insert(Iterable<S> entities) {
        return rideRepository.insert(entities);
    }
}
