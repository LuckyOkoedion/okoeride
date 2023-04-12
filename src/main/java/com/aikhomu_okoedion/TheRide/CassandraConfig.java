package com.aikhomu_okoedion.TheRide;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;

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


    @Bean
    public CqlSession cqlSession() {
      return CqlSession.builder()
               .addContactPoint( new InetSocketAddress(this.contactpoints, Integer.parseInt(this.port)))
               .withAuthCredentials(this.username, this.password)
               .withKeyspace(this.keyspace)
               .build();
    }








}
