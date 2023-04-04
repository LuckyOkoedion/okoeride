package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DriverDBTestAdapter implements DriverRepository {

    @Override
    public Driver save(Driver entity) {
        return entity;
    }

    @Override
    public <S extends Driver> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Driver> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public List<Driver> findAllById(Iterable<Integer> integers) {
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
    public void delete(Driver entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Driver> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Slice<Driver> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Driver> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Driver> List<S> insert(Iterable<S> entities) {
        return null;
    }
}
