package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Driver;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.DriverRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DriverDBTestAdapter implements DriverRepository {

    // private static List<Driver> mockDB = new ArrayList<>();

    public DriverDBTestAdapter() {
//        Driver driver1 = new Driver();
//        driver1.setName("driver1");
//        driver1.setId(1000);
//        Driver driver2 = new Driver();
//        driver2.setName("driver2");
//        driver2.setId(2000);
//        Driver driver3 = new Driver();
//        driver3.setName("driver3");
//        driver1.setId(3000);
//        mockDB.add(driver1);
//        mockDB.add(driver2);
//        mockDB.add(driver3);


    }

    @Override
    public Driver save(Driver entity) {

//        mockDB.add(entity);
        return entity;
    }

    @Override
    public <S extends Driver> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Driver> findById(Integer integer) {

        List<Driver> mockDB = new ArrayList<>();

        Driver driver1 = new Driver();
        driver1.setName("driver1");
        driver1.setId(1000);
        Driver driver2 = new Driver();
        driver2.setName("driver2");
        driver2.setId(2000);
        Driver driver3 = new Driver();
        driver3.setName("driver3");
        driver3.setId(3000);
        mockDB.add(driver1);
        mockDB.add(driver2);
        mockDB.add(driver3);

        Optional<Driver> res =  mockDB.stream()
                .filter(val -> val.getId().equals(integer))
                .findFirst();
        return res;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Driver> findAll() {
        List<Driver> mockDB = new ArrayList<>();

        Driver driver1 = new Driver();
        driver1.setName("driver1");
        driver1.setId(1000);
        Driver driver2 = new Driver();
        driver2.setName("driver2");
        driver2.setId(2000);
        Driver driver3 = new Driver();
        driver3.setName("driver3");
        driver1.setId(3000);
        mockDB.add(driver1);
        mockDB.add(driver2);
        mockDB.add(driver3);

        return mockDB;
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
