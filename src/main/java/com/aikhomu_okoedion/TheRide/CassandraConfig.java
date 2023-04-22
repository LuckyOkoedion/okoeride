package com.aikhomu_okoedion.TheRide;


import org.springframework.beans.factory.annotation.Value;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.session.init.KeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.lang.Nullable;


@Configuration
@EnableCassandraRepositories(basePackages = "com.aikhomu_okoedion.TheRide.PortsAndAdapters.Driven.Adapters.DB")
public class CassandraConfig extends AbstractCassandraConfiguration {


    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;

    @Value("${spring.data.cassandra.basePackages}")
    private String basePackages;

    @Value("${spring.data.cassandra.username}")
    private String username;

    @Value("${spring.data.cassandra.password}")
    private String password;






    @Override
    protected String getKeyspaceName() {

        System.out.println("======= Inside getKeyspaceName =======");
        return this.keySpace;
    }

    @Override
    protected String getContactPoints() {
        System.out.println("======= Inside getContactPoints =======");
        return contactPoints;
    }

    @Override
    protected int getPort() {
        System.out.println("======= Inside getPort =======");
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        System.out.println("======= Inside getSchemaAction =======");
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        System.out.println("======= Inside getEntityBasePackages =======");
        return new String[] { basePackages };
    }

    @Nullable
    @Override
    protected KeyspacePopulator keyspacePopulator() {
        return new ResourceKeyspacePopulator(new ClassPathResource("init.cql"));
    }













}
