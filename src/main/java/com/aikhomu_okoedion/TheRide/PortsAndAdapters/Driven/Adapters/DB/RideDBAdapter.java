package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Ride;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RideDBAdapter implements RideRepository {


    @Autowired
    @Qualifier("rideRepository")
    RideRepository rideRepository;



    @Override
    public <S extends Ride> S save(S entity) {
        return rideRepository.save(entity);
    }

    @Override
    public <S extends Ride> Iterable<S> saveAll(Iterable<S> entities) {
        return rideRepository.saveAll(entities);
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
    public Iterable<Ride> findAll() {
        return rideRepository.findAll();
    }

    @Override
    public Iterable<Ride> findAllById(Iterable<Integer> integers) {
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
}
