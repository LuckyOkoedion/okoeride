package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GeolocationDBAdapter implements GeolocationRepository {

    @Autowired
    @Qualifier("geolocationRepository")
    GeolocationRepository geolocationRepository;

    @Override
    public <S extends Geolocation> S save(S entity) {
        return geolocationRepository.save(entity);
    }

    @Override
    public <S extends Geolocation> Iterable<S> saveAll(Iterable<S> entities) {
        return geolocationRepository.saveAll(entities);
    }

    @Override
    public Optional<Geolocation> findById(Integer integer) {
        return geolocationRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return geolocationRepository.existsById(integer);
    }

    @Override
    public Iterable<Geolocation> findAll() {
        return geolocationRepository.findAll();
    }

    @Override
    public Iterable<Geolocation> findAllById(Iterable<Integer> integers) {
        return geolocationRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return geolocationRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        geolocationRepository.deleteById(integer);
    }

    @Override
    public void delete(Geolocation entity) {
        geolocationRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        geolocationRepository.deleteAllById(integers);

    }

    @Override
    public void deleteAll(Iterable<? extends Geolocation> entities) {
        geolocationRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        geolocationRepository.deleteAll();
    }
}
