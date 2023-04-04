package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GeolocationDBTestAdapter implements GeolocationRepository {

    @Override
    public Geolocation save(Geolocation entity) {
        return entity;
    }

    @Override
    public <S extends Geolocation> List<S> saveAll(Iterable<S> entites) {
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
    public List<Geolocation> findAll() {
        return null;
    }

    @Override
    public List<Geolocation> findAllById(Iterable<Integer> integers) {
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

    @Override
    public Slice<Geolocation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Geolocation> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Geolocation> List<S> insert(Iterable<S> entities) {
        return null;
    }
}
