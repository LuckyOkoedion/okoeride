package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDBAdapter implements CustomerRepository {

    @Autowired
    @Qualifier("customerRepository")
    CustomerRepository customerRepository;


    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> entites) {
        return customerRepository.saveAll(entites);
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
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllById(Iterable<Integer> integers) {
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

    @Override
    public Slice<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public <S extends Customer> S insert(S entity) {
        return customerRepository.insert(entity);
    }

    @Override
    public <S extends Customer> List<S> insert(Iterable<S> entities) {
        return customerRepository.insert(entities);
    }
}
