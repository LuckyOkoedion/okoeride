package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerDBAdapter implements CustomerRepository {

    @Autowired
    @Qualifier("customerRepository")
    CustomerRepository customerRepository;

    @Override
    public <S extends Customer> S save(S entity) {
        return customerRepository.save(entity);
    }

    @Override
    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
        return customerRepository.saveAll(entities);
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return customerRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return customerRepository.existsById(integer);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> integers) {
        return customerRepository.findAllById(integers);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        customerRepository.deleteById(integer);

    }

    @Override
    public void delete(Customer entity) {
        customerRepository.delete(entity);

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        customerRepository.deleteAllById(integers);

    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
