package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.Core.Domain.Geolocation;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.GeolocationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GeolocationDBTestAdapter implements GeolocationRepository {

 //   private static List<Geolocation> mockDB = new ArrayList<>();


    public GeolocationDBTestAdapter() {
//        Geolocation driver1Location = new Geolocation();
//        driver1Location.setId(1000);
//        driver1Location.setDriverId(1000);
//        driver1Location.setY(15);
//        driver1Location.setX(20);
//
//        Geolocation driver2Location = new Geolocation();
//
//        driver2Location.setId(2000);
//        driver2Location.setDriverId(2000);
//        driver2Location.setY(17);
//        driver2Location.setX(27);
//
//        Geolocation driver3Location = new Geolocation();
//
//        driver3Location.setId(3000);
//        driver3Location.setDriverId(3000);
//        driver3Location.setY(19);
//        driver3Location.setX(30);
//
//        Geolocation customer1Location = new Geolocation();
//
//        customer1Location.setId(4000);
//        customer1Location.setCustomerId(1000);
//        customer1Location.setY(18);
//        customer1Location.setX(29);
//
//        Geolocation customer2Location = new Geolocation();
//
//        customer2Location.setId(5000);
//        customer2Location.setCustomerId(2000);
//        customer2Location.setY(19);
//        customer2Location.setX(20);
//
//        Geolocation customer3Location = new Geolocation();
//
//        customer3Location.setId(6000);
//        customer3Location.setCustomerId(3000);
//        customer3Location.setY(23);
//        customer3Location.setX(25);
    }




    @Override
    public Geolocation save(Geolocation entity) {

       // mockDB.add(entity);
        return entity;
    }

    @Override
    public <S extends Geolocation> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Geolocation> findById(Integer integer) {
        List<Geolocation> mockDB = new ArrayList<>();

        Geolocation driver1Location = new Geolocation();
        driver1Location.setId(1000);
        driver1Location.setDriverId(1000);
        driver1Location.setY(15);
        driver1Location.setX(20);

        Geolocation driver2Location = new Geolocation();

        driver2Location.setId(2000);
        driver2Location.setDriverId(2000);
        driver2Location.setY(17);
        driver2Location.setX(27);

        Geolocation driver3Location = new Geolocation();

        driver3Location.setId(3000);
        driver3Location.setDriverId(3000);
        driver3Location.setY(19);
        driver3Location.setX(30);

        Geolocation customer1Location = new Geolocation();

        customer1Location.setId(4000);
        customer1Location.setCustomerId(1000);
        customer1Location.setY(18);
        customer1Location.setX(29);

        Geolocation customer2Location = new Geolocation();

        customer2Location.setId(5000);
        customer2Location.setCustomerId(2000);
        customer2Location.setY(19);
        customer2Location.setX(20);

        Geolocation customer3Location = new Geolocation();

        customer3Location.setId(6000);
        customer3Location.setCustomerId(3000);
        customer3Location.setY(23);
        customer3Location.setX(25);

        mockDB.add(driver1Location);
        mockDB.add(driver2Location);
        mockDB.add(driver3Location);
        mockDB.add(customer1Location);
        mockDB.add(customer2Location);
        mockDB.add(customer3Location);

        List<Geolocation> filtered = mockDB.stream().filter(val -> val.getId() == integer).collect(Collectors.toList());
        return Optional.ofNullable(filtered.get(0));
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Geolocation> findAll() {

        List<Geolocation> mockDB = new ArrayList<>();

        Geolocation driver1Location = new Geolocation();
        driver1Location.setId(1000);
        driver1Location.setDriverId(1000);
        driver1Location.setY(15);
        driver1Location.setX(20);

        Geolocation driver2Location = new Geolocation();

        driver2Location.setId(2000);
        driver2Location.setDriverId(2000);
        driver2Location.setY(17);
        driver2Location.setX(27);

        Geolocation driver3Location = new Geolocation();

        driver3Location.setId(3000);
        driver3Location.setDriverId(3000);
        driver3Location.setY(19);
        driver3Location.setX(30);

        Geolocation customer1Location = new Geolocation();

        customer1Location.setId(4000);
        customer1Location.setCustomerId(1000);
        customer1Location.setY(18);
        customer1Location.setX(29);

        Geolocation customer2Location = new Geolocation();

        customer2Location.setId(5000);
        customer2Location.setCustomerId(2000);
        customer2Location.setY(19);
        customer2Location.setX(20);

        Geolocation customer3Location = new Geolocation();

        customer3Location.setId(6000);
        customer3Location.setCustomerId(3000);
        customer3Location.setY(23);
        customer3Location.setX(25);

        mockDB.add(driver1Location);
        mockDB.add(driver2Location);
        mockDB.add(driver3Location);
        mockDB.add(customer1Location);
        mockDB.add(customer2Location);
        mockDB.add(customer3Location);

        return mockDB;
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
