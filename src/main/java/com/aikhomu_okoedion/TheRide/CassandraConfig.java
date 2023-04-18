package com.aikhomu_okoedion.TheRide;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import org.springframework.data.cassandra.core.cql.session.init.KeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.lang.Nullable;


@Configuration
@EnableCassandraRepositories(basePackages = "com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB")
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspace;


    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;

    @Value("${spring.data.cassandra.port}")
    private String port;

    @Value("${spring.data.cassandra.contact-points}")
    private String contactpoints;



    @Override
    protected String getKeyspaceName() {
        return this.keyspace;
    }

    @Nullable
    @Override
    protected KeyspacePopulator keyspacePopulator() {
        return new ResourceKeyspacePopulator(new ClassPathResource("init.cql"));
    }









}
