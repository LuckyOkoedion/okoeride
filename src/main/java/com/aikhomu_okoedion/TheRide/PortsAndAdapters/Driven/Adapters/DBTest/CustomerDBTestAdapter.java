package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDBTestAdapter implements CustomerRepository {


    @Override
    public Customer save(Customer entity) {
        return entity;
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public List<Customer> findAllById(Iterable<Integer> integers) {
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
    public void delete(Customer entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Slice<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Customer> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Customer> List<S> insert(Iterable<S> entities) {
        return null;
    }
}
