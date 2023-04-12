package com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DBTest;

import com.aikhomu_okoedion.TheRide.Core.Domain.Customer;
import com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Ports.Repositories.CustomerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerDBTestAdapter implements CustomerRepository {

//    private static List<Customer> mockDB = new ArrayList<>();

    public CustomerDBTestAdapter() {
//        Customer customer1 = new Customer();
//        customer1.setId(1000);
//        customer1.setName("customer1");
//        Customer customer2 = new Customer();
//        customer2.setId(2000);
//        customer2.setName("customer2");
//        Customer customer3 = new Customer();
//        customer3.setId(3000);
//        customer3.setName("customer3");
//
//        mockDB.add(customer1);
//        mockDB.add(customer2);
//        mockDB.add(customer3);


    }


    @Override
    public Customer save(Customer entity) {
       // mockDB.add(entity);
        return entity;
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> entites) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Integer integer) {

        List<Customer> mockDB = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1000);
        customer1.setName("customer1");
        Customer customer2 = new Customer();
        customer2.setId(2000);
        customer2.setName("customer2");
        Customer customer3 = new Customer();
        customer3.setId(3000);
        customer3.setName("customer3");

        mockDB.add(customer1);
        mockDB.add(customer2);
        mockDB.add(customer3);


        List<Customer> filtered = mockDB.stream().filter(val -> val.getId() == integer).collect(Collectors.toList());
        return Optional.ofNullable(filtered.get(0));
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> mockDB = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1000);
        customer1.setName("customer1");
        Customer customer2 = new Customer();
        customer2.setId(2000);
        customer2.setName("customer2");
        Customer customer3 = new Customer();
        customer3.setId(3000);
        customer3.setName("customer3");

        mockDB.add(customer1);
        mockDB.add(customer2);
        mockDB.add(customer3);
        return mockDB;
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
