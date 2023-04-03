package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DriverDBAdapter implements DriverRepository {

    @Autowired
    @Qualifier("driverRepository")
    DriverRepository driverRepository;

    public DriverDBAdapter() {

    }

    public DriverDBAdapter(DriverRepository driverRepository) {

        this.driverRepository = driverRepository;

    }

    @Override
    public <S extends Driver> S save(S entity) {
        return driverRepository.save(entity);
    }

    @Override
    public <S extends Driver> Iterable<S> saveAll(Iterable<S> entities) {
        return driverRepository.saveAll(entities);
    }

    @Override
    public Optional<Driver> findById(Integer integer) {
        return driverRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return driverRepository.existsById(integer);
    }

    @Override
    public Iterable<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Iterable<Driver> findAllById(Iterable<Integer> integers) {
        return driverRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return driverRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        driverRepository.deleteById(integer);
    }

    @Override
    public void delete(Driver entity) {
        driverRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        driverRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Driver> entities) {
        driverRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        driverRepository.deleteAll();

    }
}
